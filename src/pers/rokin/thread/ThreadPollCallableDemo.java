package pers.rokin.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPollCallableDemo implements Callable<String>{
    private int id;

    public ThreadPollCallableDemo(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("call()方法被自动调用,干活！！！             " + Thread.currentThread().getName());
        Thread.sleep(2000);
        return "call()方法被自动调用，任务的结果是：" + id + "    " + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<Future<String>>();
        // 创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = newCachedThreadPool.submit(new ThreadPollCallableDemo(i));
            //将任务执行结果存储到List中
            list.add(future);
        }

        //启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用。
        newCachedThreadPool.shutdown();
        for(Future<String> future : list) {
            System.out.println(future.get() + "--date--> " +new Date());
        }
    }

}
