package org.example.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futre {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();   //直接用Executors创建，方便就完事了
        Future<String> future = executor.submit(() -> "我是字符串!");     //使用submit提交任务，会返回一个Future对象，注意提交的对象可以是Runable也可以是Callable，这里使用的是Callable能够自定义返回值
        System.out.println(future.get());    //如果任务未完成，get会被阻塞，任务完成返回Callable执行结果返回值
        executor.shutdown();
    }

}
