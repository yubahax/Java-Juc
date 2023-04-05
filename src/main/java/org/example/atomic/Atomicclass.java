package org.example.atomic;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Atomicclass {
        private static AtomicInteger i = new AtomicInteger(0);
        public static void main(String[] args) throws InterruptedException {
//            Runnable r = () -> {
//                for (int j = 0; j < 100000; j++)
//                    i.getAndIncrement();
//                System.out.println("自增完成！");
//            };
//            new Thread(r).start();
//            new Thread(r).start();
//            TimeUnit.SECONDS.sleep(1);
//            System.out.println(i.get());

            AtomicIntegerArray array = new AtomicIntegerArray(new int[]{0, 4, 1, 3, 5});
            Runnable r = () -> {
                for (int i = 0; i < 100000; i++) {
                    array.getAndAdd(0, 1);
                }
            };
            new Thread(r).start();
            new Thread(r).start();
            TimeUnit.SECONDS.sleep(1);
            System.out.println(array.get(0));
            System.out.println(array);
        }
}


