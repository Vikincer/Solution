package pers.rokin.thread;

public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i<100; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
