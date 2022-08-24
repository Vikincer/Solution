package pers.rokin.serialize;

import java.io.*;

public class TransientTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializeUser();
        DeSerializeUser();

    }
    private static void SerializeUser() throws IOException {
        User user = new User();
        user.setName("测试");
        user.setPassword("1234");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Hword\\java\\java_project\\javaee\\src\\pers\\rokin\\serialize\\data.txt"));
        oos.writeObject(user);
        oos.close();
        System.out.println("普通字段序列化：" + user.getName());
        System.out.println("transient关键字段序列化：" + user.getPassword());
    }
    private static void DeSerializeUser() throws IOException, ClassNotFoundException {
        File file = new File("D:\\Hword\\java\\java_project\\javaee\\src\\pers\\rokin\\serialize\\data.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User user = (User) ois.readObject();
        System.out.println("普通字段反序列化：" + user.getName());
        System.out.println("transient关键字段反序列化：" + user.getPassword());

    }
}
