package program;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _1114 {
    public static void main(String[] args) throws InterruptedException {
        // Foo foo = new Foo();
        // Foo_1 foo = new Foo_1();
        Foo_3 foo = new Foo_3();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        };
        foo.first(runnable);
        foo.second(runnable);
        foo.third(runnable);
    }
    public static class Foo {
        public final CountDownLatch firstDone;
        public final CountDownLatch secondDone;
        public Foo() {
            firstDone = new CountDownLatch(1); //当做第一个任务完成的信号
            secondDone = new CountDownLatch(1); //当做第二个任务完成的信号
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            firstDone.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            firstDone.await();
            printSecond.run();
            secondDone.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            secondDone.await();
            printThird.run();
        }
    }

    //方法2.使用Lock锁的多条件变量
    public static class Foo_2 {
        private final Lock lock;
        private final Condition secondCondition;
        private final Condition thirdCondition;
        int flag = 1;

        public Foo_2() {
            lock = new ReentrantLock();
            secondCondition = lock.newCondition();
            thirdCondition = lock.newCondition();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock(); //由于三个方法同时运行，所以需要上锁，由于flag的值是1，所以第一个方法一定先拿到锁
            try {
                // 打印 "first"
                printFirst.run();
                secondCondition.signal(); //唤醒第二个方法
                flag++; //flag变为2
            } finally {
                lock.unlock(); //一定要记得解锁，否则其他线程无法获得锁
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock(); //由于三个方法同时运行，所以需要上锁，由于flag的值是2，所以第二个方法一定先拿到锁
            try {
                while(flag != 2){
                    secondCondition.await(); //等待被唤醒，后续代码不会执行
                }
                // 打印 "second"
                printSecond.run();
                flag++; //flag变为3
                thirdCondition.signal(); //唤醒第三个方法
            } finally {
                lock.unlock(); //一定记得解锁，否则其他线程无法获得锁
            }
        }
        public void third(Runnable printThird) throws InterruptedException {
            lock.lock(); //由于三个方法同时运行，所以需要上锁，由于flag的值是3，所以第三个方法一定先拿到锁
            try {
                while(flag != 3){
                    thirdCondition.await(); //等待被唤醒，后续代码不会执行
                }
                // 打印 "third"
                printThird.run();
            } finally {
                lock.unlock(); //一定记得解锁，否则其他线程无法获得锁
            }
        }
    }

    //方法2.使用Lock锁的多条件变量
    public static class Foo_1 {
        private final Lock lock;
        private final Condition secondCondition;
        private final Condition thirdCondition;
        public Foo_1() {
            lock = new ReentrantLock();
            secondCondition = lock.newCondition();
            thirdCondition = lock.newCondition();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock(); //由于三个方法同时运行，所以需要上锁，由于flag的值是1，所以第一个方法一定先拿到锁
            try {
                // 打印 "first"
                printFirst.run();
                secondCondition.signal(); //唤醒第二个方法
            } finally {
                lock.unlock(); //一定要记得解锁，否则其他线程无法获得锁
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                secondCondition.await(); //等待被唤醒，后续代码不会执行
                // 打印 "second"
                printSecond.run();
                thirdCondition.signal(); //唤醒第三个方法
            } finally {
                lock.unlock(); //一定记得解锁，否则其他线程无法获得锁
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                thirdCondition.await(); //等待被唤醒，后续代码不会执行
                // 打印 "third"
                printThird.run();
            } finally {
                lock.unlock(); //一定记得解锁，否则其他线程无法获得锁
            }
        }
    }

    public static class Foo_3 {
        public Foo_3() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            Thread.sleep(1000);
            printSecond.run();
        }

        public void third(Runnable printThird) throws InterruptedException {
            Thread.sleep(3000);
            printThird.run();
        }
    }
}
