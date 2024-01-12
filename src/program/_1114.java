package program;

import java.util.concurrent.CountDownLatch;

public class _1114 {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ;
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
}
