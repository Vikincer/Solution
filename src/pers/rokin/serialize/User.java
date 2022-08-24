package pers.rokin.serialize;

import java.io.Serializable;

public class User  implements Serializable {
    /*
        Java序列化是指把Java对象转换为字节序列的过程。
        Java反序列化是指把字节序列恢复为Java对象的过程。

    * 当一个父类实现序列化，子类自动实现序列化；而子类实现了 Serializable 接口，父类也需要实现Serializable 接口。
    * */
    private static final long serialVersionUID = 1L;
    private String name;
    private transient String password;
    /*
    * transient代表对象的临时数据。
        如果你不想让对象中的某个成员被序列化可以在定义它的时候加上 transient 关键字进行修饰，
        这样，在对象被序列化时其就不会被序列化。
        transient 修饰过的成员反序列化后将赋予默认值，即 0 或 null。
        有些时候像银行卡号这些字段是不希望在网络上传输的，
        transient的作用就是把这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化。
    * */

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
