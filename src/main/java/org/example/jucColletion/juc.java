package org.example.jucColletion;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class juc {
    public static void main(String[] args) throws InterruptedException {
//        List<String> list = new CopyOnWriteArrayList<>();  //这里使用CopyOnWriteArrayList来保证线程安全
//        Runnable r = () -> {
//            for (int i = 0; i < 100; i++)
//                list.add("lbwnb");
//        };
//        for (int i = 0; i < 100; i++) {
//            new Thread(r).start();
//        }
//        TimeUnit.SECONDS.sleep(1);
//        System.out.println(list.size());

        Map<Integer, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    map.put(finalI * 100 + j, "lbwnb");
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(map.size());




    }

}
