package org.example.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWritelock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
//        lock.readLock().lock();
//        new Thread(lock.readLock()::lock).start();
        //一个写锁，多个读锁
        lock.writeLock().lock();
//        new Thread(lock.writeLock()::lock).start();
        new Thread(lock.readLock()::lock).start();
    }

}
