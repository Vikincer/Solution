package pers.rokin.Reflex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class ReflexBasic {
    //有Declared关键词是可以公共也可以非公共
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, IOException {

        Class<?> c = Class.forName("pers.rokin.Reflex.Student");        //写法一

//        Class<?> c = Student.class;    //写法二
//
//        Student c = new Student(); //写法三
//        c.getClass();

        Constructor con = c.getConstructor(String.class,int.class,String.class);
        Object obj = con.newInstance("神马",20,"天宫");
        System.out.println(obj);
        System.out.println("----------");

        Constructor con1 = c.getDeclaredConstructor(String.class);
        con1.setAccessible(true);
        Object obj1 = con1.newInstance("浮云");   //由于是私有方法 无法访问（java.lang.IllegalAccessException）， 故需要 line23 来取消访问检查 实现暴力反射
        System.out.println(obj1);
        System.out.println("----------");

//        Field[] fields = c.getFields(); //访问所有公共成员变量

        Field fieldaddress = c.getField("address"); //访问单个公共成员变量
        System.out.println(fieldaddress);
        //如何用成员变量
        Constructor con2 = c.getConstructor();
        Object obj2 = con2.newInstance();
        fieldaddress.set(obj2,"阎罗殿");
        System.out.println(obj2);
        System.out.println("----------");

        Field[] fields = c.getDeclaredFields();//访问所有成员变量
        for (Field field : fields){
            System.out.println(field);
        }
        System.out.println("----------");

        Constructor con3 = c.getConstructor();
        Object obj3 = con3.newInstance();

        Field fieldname = c.getDeclaredField("name");
        fieldname.setAccessible(true);
        Field fieldage = c.getDeclaredField("age");
        Field fieldaddress1 = c.getField("address");
        fieldname.set(obj3,"关羽");
        fieldage.set(obj3,18);
        fieldaddress1.set(obj3,"长安");
        System.out.println(obj3);
        System.out.println("----------");

        Constructor con4 = c.getConstructor();
        Object obj4 = con4.newInstance();
//        Method[] methods = c.getMethods();//包含继承的方法 不包含私有
        Method[] methods = c.getDeclaredMethods();//包含私有 不包含继承的方法
        for (Method method : methods){
            System.out.println(method);
        }
        System.out.println("----------");

        //调用方法
        Constructor con5 = c.getConstructor();
        Object obj5 = con5.newInstance();
        Method m = c.getMethod("Method1");
        m.invoke(obj5);
        System.out.println("----------");

        //利用反射将集合ArrayList<Integer>中添加一个字符串数据
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        Class c6 = arrayList.getClass();
        Method m6 = c6.getMethod("add", Object.class);
        m6.invoke(arrayList,"Hello");
        m6.invoke(arrayList,"word");
        m6.invoke(arrayList,"java");
        System.out.println(arrayList);
        System.out.println("----------");

        //通过配置文件运行类中的方法
        Properties proper = new Properties();
        FileReader fr = new FileReader("D:\\Hword\\java\\java_project\\src\\pers\\rokin\\Reflex\\class.txt");
        proper.load(fr);
        fr.close();
        String className = proper.getProperty("className");
        String methodName = proper.getProperty("methodName");
        Class c7 = Class.forName(className);
        Constructor con7 = c7.getConstructor();
        Object obj7 = con7.newInstance();
        Method m7 = c7.getMethod(methodName);
        m7.invoke(obj7);

    }
}
