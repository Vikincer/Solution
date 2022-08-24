package pers.rokin.callname;

import java.io.*;
//序列化 反序列化 操作
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        write();
        read();
    }
    public static void write() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\Hword\\java\\java_project\\javase\\src\\pers\\rokin\\callname\\ObjectStream.txt"));
        Student student = new Student(1,"常山赵子龙");
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
    }
    public static void read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\Hword\\java\\java_project\\javase\\src\\pers\\rokin\\callname\\ObjectStream.txt"));
        Object o = objectInputStream.readObject();
        Student student = (Student) o;
        System.out.println(student);
    }
}
