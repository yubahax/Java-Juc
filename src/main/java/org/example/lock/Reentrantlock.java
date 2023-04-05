package org.example.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock & condition
 */

public class Reentrantlock {
        private static int i = 0;
        public static void main(String[] args) throws InterruptedException {
//            Lock testLock = new ReentrantLock();   //可重入锁ReentrantLock类是Lock类的一个实现
//            Runnable action = () -> {
//                for (int j = 0; j < 100000; j++) {   //还是以自增操作为例
//                    testLock.lock();    //加锁，加锁成功后其他线程如果也要获取锁，会阻塞，等待当前线程释放
//                    i++;
//                    testLock.unlock();  //解锁，释放锁之后其他线程就可以获取这把锁了（注意在这之前一定得加锁，不然报错）
//                }
//            };
//            new Thread(action).start();
//            new Thread(action).start();
//            Thread.sleep(1000);   //等上面两个线程跑完
//            System.out.println(i);
            ReentrantLock lock = new ReentrantLock();
            lock.lock();
            lock.lock();   //连续加锁2次
            new Thread(() -> {
                System.out.println("线程2想要获取锁");
                lock.lock();
                System.out.println("线程2成功获取到锁");
            }).start();
            lock.unlock();
            System.out.println("线程1释放了一次锁");
            TimeUnit.SECONDS.sleep(1);
            lock.unlock();
            System.out.println("线程1再次释放了一次锁");  //释放两次后其他线程才能加锁
        }
}