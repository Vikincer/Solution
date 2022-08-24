package pers.rokin.designPattern;


/*
* 设计模式（Design pattern），
* 提供了在软件开发过程中面临的一些问题的最佳解决方案，是Java开发者必修的一门课程。
* 主要分创建型模式、
* 结构型模式
* 行为型模式。
* 其中接下来我们要写的是单例模式，属于创建型模式。

单例模式，顾名思义就是只有一个实例，并且她自己负责创建自己的对象，
* 这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。
* 下面我们来看下有哪几种实现方式吧。

* */
public class SingleCase {
    /*
    * 懒汉式，
    * 顾名思义就是实例在用到的时候才去创建，
    * “比较懒”，用的时候才去检查有没有实例，如果有则返回，没有则新建。
    * 有线程安全和线程不安全两种写法，区别就是synchronized关键字。
    * */

    private static SingleCase lhan;
    public SingleCase(){}//私有构造方法
    public static SingleCase getInstance(){
        synchronized (SingleCase.class){
            if(lhan == null){
                lhan = new SingleCase();
            }
        }
        return lhan;
    }

    /*
    * 饿汉式，
    * 从名字上也很好理解，就是“比较勤”，
    * 实例在初始化的时候就已经建好了，不管你有没有用到，都先建好了再说。
    * 好处是没有线程安全的问题，坏处是浪费内存空间。
    * */

    private static SingleCase ehan = new SingleCase();
//    public SingleCase(){}
//    public static SingleCase getInstance(){
//        return ehan;
//    }

    /*
    * 双检锁，又叫双重校验锁，
    * 综合了懒汉式和饿汉式两者的优缺点整合而成。
    * 看下面代码实现中，特点是在synchronized关键字内外都加了一层 if 条件判断，
    * 这样既保证了线程安全，又比直接上锁提高了执行效率，还节省了内存空间。
    * */

    private static SingleCase doubleCheck;
//    public SingleCase(){}
//    public static SingleCase getInstance(){
//        if(doubleCheck == null){//线程1 2 3 到达这里
//            synchronized (SingleCase.class){// 线程1在这里进行判断继续往下进行 线程2 3等待
//                if(doubleCheck == null){//线程1到这里发现doubleCheck为空 继续执行if语句
                        //执行完成后退出同步区域，线程2进入同步区域，如果这里不加一次判断，
                        //就会造成doubleCheck再次实例化，由于增加了判断
                        //线程2到这里发现doubleCheck已经被实例化于是跳过了if语块
//                    doubleCheck = new SingleCase();

//                }
//            }
//        }
//        return doubleCheck;
//    }

    /*
    *静态内部类
    *方式效果类似双检锁，但实现更简单。但这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
    **/

    private static class SingletonHolder{
        private static final SingleCase SINGLETON = new SingleCase();
    }
//    public SingleCase(){}
//    public static final SingleCase getInstance(){
//        return SingletonHolder.SINGLETON;
//    }

    /*
    * 枚举
    * 这种方式是比较少见的一种实现方式，但是看下面的代码实现，却更简洁清晰。并且她还自动支持序列化机制，绝对防止多次实例化。
    * */
//    public enum SingleCase{
//        INSTANCE;
//        public void anyMethod(){
//
//        }
//    }
}
