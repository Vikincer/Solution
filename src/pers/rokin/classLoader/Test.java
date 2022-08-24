package pers.rokin.classLoader;

import pers.rokin.callname.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    /*
    * 1、加载
        * 将class文件字节码内容加载到内存中，
        * 并将这些静态数据转换成方法区的运行时数据结构，
        * 生成一个代表这个类的java.lang.class对象。
    *2、链接
        * 将Java类的二进制代码合并到JVM的运行状态之中的过程。
        * 验证：确保加载的类信息符合JVM规范，没有安全方面的问题；
        * 准备：正式为类变量分配内存并设置类变量默认初始值的阶段，这些内存都将在方法区内进行分配；
        * 解析：虚拟机常量池内的符号引用（常量名）替换为直接引用（地址）的过程。
     *3、初始化
     * 执行类构造器<clinit>()方法的过程。类构造器<clinit>()方法是由编译期自动收集类中所有类变量的赋值动作和静态代码块中的语句合并产生的。（类构造器是构造类信息的，不是构造该类对象的构造器）。
     * 当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先触发其父类的初始化。
     * 虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确加锁和同步。
    * */

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        //获得class对象
        Class c1 = Class.forName("pers.rokin.callname.Student");
        //1、构造一个对象，本质是无参构造器
        Student user1 = (Student) c1.newInstance();
        System.out.println(user1);

        //2、通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(int.class, String.class);
        Student user2 = (Student) constructor.newInstance(1,"郭一诺");
        System.out.println(user2);

        //3、通过反射调用普通方法
        Student user3 = (Student) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke激活
        setName.invoke(user3,"素小暖");
        System.out.println(user3.getName());

        //4、通过反射操作属性
        Student user4 = (Student) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //true：取消Java语言访问检查
        name.setAccessible(true);
        name.set(user4,"素小暖2");
        System.out.println(user4.getName());
    }

}
