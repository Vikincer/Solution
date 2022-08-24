package pers.rokin.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
//        Demo();
//        tyyLockDemo();
        ConditionDemo();
    }
    public static void Demo(){
        ReentrantLock reentrantLock = new ReentrantLock();
        System.out.println("reentrantLock->start");

        reentrantLock.lock();
        try {
            System.out.println("睡眠2秒");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
            System.out.println("reentrantLock->unlock");
        }
    }
    public static void tyyLockDemo(){
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread1 = new tyrLockThread(reentrantLock);
        thread1.setName("thread1");
        thread1.start();
        Thread thread2= new tyrLockThread(reentrantLock);
        thread2.setName("thread2");
        thread2.start();

    }
    static class tyrLockThread extends Thread{
        ReentrantLock reentrantLock;
        public tyrLockThread(ReentrantLock reentrantLock){
            this.reentrantLock = reentrantLock;
        }
        public void run(){
            try {
                System.out.println("tryLocThread -> run "+ Thread.currentThread().getName());
                boolean tryLock = reentrantLock.tryLock(3, TimeUnit.SECONDS);
                if(tryLock){
                    System.out.println("tryLock success!"+Thread.currentThread().getName());
                    System.out.println("睡一下" + Thread.currentThread().getName());
                    Thread.sleep(3000);
                    System.out.println("行了" + Thread.currentThread().getName());
                } else {
                    System.out.println(Thread.currentThread().getName() + "超时了");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("unlock()");
                reentrantLock.unlock();
            }

        }
    }
    public static void ConditionDemo(){
        ThreadCondition thread_condition = new ThreadCondition();
        thread_condition.setName("测试Condition的线程");
        thread_condition.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread_condition.singal();
    }
    static class ThreadCondition extends Thread{

        public void run(){
            await();
        }
        private ReentrantLock lock = new ReentrantLock();
        public Condition condition = lock.newCondition();

        public void await() {
            try {
                System.out.println("await()->lock");
                lock.lock();
                System.out.println(Thread.currentThread().getName() + ":我在等待通知的到来...");
                condition.await();//await 和 signal 对应
                //condition.await(2, TimeUnit.SECONDS); //设置等待超时时间
                System.out.println(Thread.currentThread().getName() + ":等到通知了，我继续执行>>>");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("await()->unlock");
                lock.unlock();
            }
        }

        public void singal() {
            try {
                System.out.println("singal()->lock");
                lock.lock();
                System.out.println("我要通知在等待的线程，condition.signal()");
                condition.signal();//await 和 signal 对应
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("singal()->unlock");
                lock.unlock();
            }
        }
    }
}

