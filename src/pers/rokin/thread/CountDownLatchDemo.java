package pers.rokin.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo implements Callable<Integer>{

        static int threadCount = 15;
        static int awaitMillisecond = 3000;
        static CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        int id;
        public CountDownLatchDemo(int id) {
            this.id = id;
        }

        public static void main(String[] args) throws InterruptedException, ExecutionException {
            boolean fireFlag = true;
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(threadCount);
            List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
            for(int i = 0; i< threadCount; i++) {
                Future<Integer> future = newFixedThreadPool.submit(new CountDownLatchDemo(i));
                futureList.add(future);
            }
            for(int i = 0; i< threadCount; i++) {
                Future<Integer> future = futureList.get(i);
                if(0 == future.get()) {
                    fireFlag = false;
                    break;
                }
            }
            if(true == fireFlag) {
                System.out.println(getCurrentTime() + "fire.");
            }else {
                System.out.println(getCurrentTime() + "countDownLatch.await().");
                //设置超时时间awaitMillisecond
                countDownLatch.await(awaitMillisecond, TimeUnit.MILLISECONDS);
                System.out.println(getCurrentTime() + Thread.currentThread().getName() + ", 线程阻塞");
                //线程阻塞
                countDownLatch.await();
                System.out.println(getCurrentTime() + "thread contains error, do not fire.");
            }
            newFixedThreadPool.shutdown();
        }

        @Override
        public Integer call() {
            try {
                if(id < 9) {
                    System.out.println(getCurrentTime() + Thread.currentThread().getName()+", 检查完毕.");
                    countDownLatch.countDown();
                    return 1;
                }else {
                    //int a = 1/0;
                    System.out.println(getCurrentTime() + Thread.currentThread().getName()+", 存在异常，检查中...");
                    Thread.sleep(awaitMillisecond);
                    System.out.println(getCurrentTime() + Thread.currentThread().getName()+", 检查失败.");
                    return 0;
                }
            }catch (Exception e) {
                System.out.println("call exception.");
                return 0;
            }
        }

        private static String getCurrentTime() {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String format = sdf.format(date);
            String ret = "[" + format + "]  ";
            return ret;
        }

}
