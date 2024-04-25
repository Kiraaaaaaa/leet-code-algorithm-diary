package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("本线程准备获取锁");
        ReentrantLock lock = new ReentrantLock();
        try{
            lock.lockInterruptibly(); //获取锁
            System.out.println("本线程获取锁成功");
            System.out.println("开始打断本线程");
            Thread.currentThread().interrupt(); //打断线程
            Thread.sleep(1000); //睡眠一秒，如果不睡眠还是会运行下一行，因为打断线程不能阻止运行时的线程
            System.out.println("这是一行不会被执行的代码");
        } catch (InterruptedException e){ //被打断的线程会抛出InterruptedException异常，必须处理
            e.printStackTrace();
            System.out.println("线程被打断了");
            return;
        } finally {
            lock.unlock();
        }
    }
    static class Solution {
        //方法1.枚举三路车的个数
        public long method(int x, int y) {
            int res = -1;
            for (int i = 0; i <= x; i++) {
                if(y == i*3 + (x-i)*4){
                    res = i;
                    break;
                }
            }
            return res;
        }
    }
}
