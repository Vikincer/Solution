package pers.rokin.IO;

import java.nio.CharBuffer;
import java.util.Arrays;

/*
* 在nio 中有三大核心组件： channel buffer selector
*
* 传统的IO面向流 每次可以从流中读取一个或者多个字节，只能向后读取，不能像前移动。
*
* */
public class NIODemo {
    public static void main(String [] args){
//        buffDemo();
        buffDemo1();
//        buffDemo2();
    }

    public static void buffDemo(){
        CharBuffer allocate = CharBuffer.allocate(12);

        System.out.println("capacity：" +allocate.capacity() + " limit：" + allocate.limit() + " position：" + allocate.position());

        allocate.put('我');
        allocate.put('a');
        allocate.put('s');
        allocate.put('d');
        allocate.put('c');
        allocate.put('f');
        System.out.println("capacity：" +allocate.capacity() + "limit：" + allocate.limit() + "position：" + allocate.position());

        //把缓冲区切换为读模式
        allocate.flip();
        System.out.println("capacity：" +allocate.capacity() + "limit：" + allocate.limit() + "position：" + allocate.position());

        //读取缓冲区的数据
        System.out.println(allocate.get());     //我
        System.out.println("capacity：" +allocate.capacity() + "limit：" + allocate.limit() + "position：" + allocate.position());

        //再次存数据
        allocate.put('Q');
        System.out.println("capacity：" +allocate.capacity() + "limit：" + allocate.limit() + "position：" + allocate.position());

        //设置标记
        allocate.mark();
        System.out.println(allocate.get());
        System.out.println("capacity：" +allocate.capacity() + "limit：" + allocate.limit() + "position：" + allocate.position());

        //把position重置为mark标志位置
        allocate.reset();
        System.out.println("capacity：" +allocate.capacity() + "limit：" + allocate.limit() + "position：" + allocate.position());

        //把allocate中未读的数据复制到position为0的位置
        allocate.compact();
        System.out.println("capacity：" +allocate.capacity() + "limit：" + allocate.limit() + "position：" + allocate.position());
    }

    public static void buffDemo1(){
        CharBuffer buf = CharBuffer.allocate(16);
        buf.put("asdfghjkl");
        buf.flip();
        System.out.println(buf);

        char [] dst = new char[5];
        CharBuffer charBuffer = buf.get(dst);
        System.out.println(Arrays.toString(dst));
        System.out.println(charBuffer);

//        buf.get();
        buf.get(dst,0,buf.remaining());
        System.out.println(Arrays.toString(dst));

        System.out.println("-----------------------------------------------");

        buf.clear();
        while(buf.hasRemaining()){
            int len = Math.min(dst.length,buf.remaining());
            buf.get(dst, 0, len);
            System.out.println(new String(dst,0,len));
        }
        System.out.println();

        char [] con = {'a','b','c'};
        System.out.println(buf.position());
        System.out.println(buf.capacity());
        System.out.println(buf.limit());
        buf.position(14);
        buf.put(con,0,buf.remaining());
        buf.flip();
        System.out.println(buf);

    }

    public static void buffDemo2(){
        CharBuffer buf1 = CharBuffer.allocate(16);

        char [] myarray = new char [16];
        CharBuffer buf2 = CharBuffer.wrap(myarray);

        //通过put向缓冲区添加数据会影响到数组对象
        buf2.put("hello");
        buf2.flip();
        System.out.println(buf2);
        System.out.println(Arrays.toString(myarray));

        //对数组做任何操作也会影响缓冲区中的对象
        myarray[0] = 'Y';
        System.out.println(buf2);

    }

}
