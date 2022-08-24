package pers.rokin.callname;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 42L;   //在反序列化中强烈建议先申明序列化UID 这样就不会因为修改后的类文件改变UID 报出异常
    private int sid;
    String name;

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public Student(){}

    public Student(int sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }
}
