package pers.rokin.thread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPollDemo implements Runnable{

        private String name;

        public ThreadPollDemo(String name) {
            this.name = "Thread" + name;
        }

        @Override
        public void run() {
            System.out.println(name + "-> start time : " + new Date());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "-> end time : " + new Date());
        }

        public static void main(String[] args) throws InterruptedException {
            singleTest();
        }

        //可缓存的线程池
        private static void cacheTest() {
            ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
            for (int i = 0; i < 10; i++) {
                ThreadPollDemo handle = new ThreadPollDemo(String.valueOf(i));
                newCachedThreadPool.execute(handle);
            }
            newCachedThreadPool.shutdown();
            System.out.println("Main Thread: Finished at:" + new Date());
        }

        //固定长度的线程池
        private static void fixedTest() {
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 10; i++) {
                ThreadPollDemo handle = new ThreadPollDemo(String.valueOf(i));
                newFixedThreadPool.execute(handle);//先执行五个，然后再执行五个
            }
            newFixedThreadPool.shutdown();
            System.out.println("Main Thread: Finished at:" + new Date());
        }

        //单线程线程池
        private static void singleTest() {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            for (int i = 0; i < 10; i++) {
                ThreadPollDemo handle = new ThreadPollDemo(String.valueOf(i));
                newSingleThreadExecutor.execute(handle);//单一线程分次执行
            }
            newSingleThreadExecutor.shutdown();
            System.out.println("Main Thread: Finished at:" + new Date());
        }

        /**
         * 固定长度的线程池，而且以延迟或者定时的方式来执行，类似Timer
         *
         * scheduleAtFixedRate 按指定频率周期执行某个任务
         * scheduleAtFixedRate ，是以上一个任务开始的时间计时，period时间过去后，检测上一个任务是否执行完毕，
         * 如果上一个任务执行完毕，则当前任务立即执行，如果上一个任务没有执行完毕，则需要等上一个任务执行完毕后立即执行。
         *
         * scheduleWithFixedDelay 周期定时执行某个任务/按指定频率间隔执行某个任务(注意)
         * scheduleWithFixedDelay，是以上一个任务结束时开始计时，period时间过去后，立即执行。
         *
         */
        private static void scheduledTest() {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(10);
            for (int i = 0; i < 3; i++) {
                ThreadPollDemo handle = new ThreadPollDemo(String.valueOf(i));
                //执行
                //newScheduledThreadPool.execute(handle);
                //延迟1秒执行
                //newScheduledThreadPool.schedule(handle, 1, TimeUnit.SECONDS);
                //延迟1秒，每隔3秒执行一遍（隔3秒执行，①如果上一次结束，立即执行；②如果上一次未结束，结束立即执行；）
                //newScheduledThreadPool.scheduleAtFixedRate(handle, 1, 3, TimeUnit.SECONDS);
                //延迟1秒，每隔3秒执行一遍(上一个任务结束开始计时)
                newScheduledThreadPool.scheduleWithFixedDelay(handle, 1, 3, TimeUnit.SECONDS);
            }
            //newScheduledThreadPool.shutdown();
            System.out.println("Main Thread: Finished at:" + new Date());
        }

}
