package pers.rokin.thread;

//StringBuffer
//JDK5开始 被StringBuilder替代 通常应该使用StringBuilder因为他支持所有相同的操作 但它更快 因为它不执行同步

//Vector
//该类改进了List接口。与新的集合实现不同，Vector被同步。如果不需要线程安全的实现，建议使用ArrayList代替Vector

//Hashtable
//该类进行了改进 实现了Map接口 与新的集合实现不同，Hashtable被同步 如果不需要线程安全的实现 建议使用HashMap代替Hashtable


public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo1 = new ThreadDemo();
        ThreadDemo threadDemo2 = new ThreadDemo();

//        System.out.println(threadDemo1.getPriority());//5
//        System.out.println(threadDemo2.getPriority());//5

        threadDemo1.setPriority(5);//setPriority 在1-10之间
        threadDemo2.setPriority(4);

//        threadDemo1.setName("thread-1");
//        threadDemo2.setName("thread-2");


        //join()  使当前线程结束后才能进行下一个线程的启动
        //用法 threadDemo1.join（）;

        //设置主线程
        Thread.currentThread().setName("主线程");
        for (int i = 0; i<10; i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        //设置守护线程（当主线程结束后 守护线程也将会结束）
        threadDemo1.setDaemon(true);
        threadDemo2.setDaemon(true);


        threadDemo1.start();
        threadDemo1.join();//join（）：线程1结束后才能执行线程2

        threadDemo2.start();

        //创建线程的第二种方法  实现runnable接口
//        RunnableDemo runnableDemo = new RunnableDemo();
//        Thread th1 = new Thread(runnableDemo,"线程1");
//        Thread th2 = new Thread(runnableDemo,"线程2");
//        th1.start();
//        th2.start();
    }
}
