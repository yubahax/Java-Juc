package org.example.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWritelock {
    public static void main(String[] args) throws InterruptedException {
//        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
//        lock.writeLock().lock();
//        lock.writeLock().lock();
//        new Thread(() -> {
//            lock.writeLock().lock();
//            System.out.println("成功获取到写锁！");
//        }).start();
//        System.out.println("释放第一层锁！");
//        lock.writeLock().unlock();
//        TimeUnit.SECONDS.sleep(1);
//        System.out.println("释放第二层锁！");
//        lock.writeLock().unlock();

//        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
//
//        Runnable action = () -> {
//            System.out.println("线程 "+Thread.currentThread().getName()+" 将在1秒后开始获取锁...");
//            lock.writeLock().lock();
//            System.out.println("线程 "+Thread.currentThread().getName()+" 成功获取锁！");
//            lock.writeLock().unlock();
//        };
//        for (int i = 0; i < 10; i++) {   //建立10个线程
//            new Thread(action, "T"+i).start();
//        }

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();
        lock.readLock().lock();
        new Thread(() -> {
            System.out.println("开始加读锁！");
            lock.readLock().lock();
            System.out.println("读锁添加成功！");
        }).start();
        TimeUnit.SECONDS.sleep(5);
        lock.writeLock().unlock();


    }

}
