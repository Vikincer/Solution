package pers.rokin.thread;

//方法锁（修饰符 synchronized） 的锁对象是 this
//静态方法锁(修饰符 static synchronized)  的锁对象是 当前类名.class
//普通锁对象是(synchronized{}) 任意对象（obj）
//三个用法 都必须满足每个方法体的锁对象是一致的


public class SellTicket implements Runnable{
    private int ticket = 100;
    private Object obj = new Object();
    @Override
    public void run() {

        synchronized (obj){
            while(true){
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + ticket + "张票");
                    ticket--;
                }
            }
        }

    }
}
