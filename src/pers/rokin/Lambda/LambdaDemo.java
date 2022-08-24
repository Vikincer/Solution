package pers.rokin.Lambda;


//需求：启动一个线程 并在控制台上输出一句话：线程启动了！

//Lambda表达式
//(形式参数) -> {代码块}
public class LambdaDemo {
    public static void main(String[] args) {
        //实现类的方法实现需求
        MyRunnable my = new MyRunnable();
        Thread t =  new Thread(my);
        t.start();

        //用匿名方法实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("（匿名）线程启动了！");
            }
        }).start();

        //用Lambda表达式 方法实现
        new Thread( () -> {
            System.out.println("（Lambda表达式）线程启动了！");
        } ).start();

        //用Runnable + Lambda表达式 实现
        Runnable runnable = ()-> System.out.println("（Runnable + Lambda表达式）线程启动了！");
        new Thread(runnable).start();
    }
}
