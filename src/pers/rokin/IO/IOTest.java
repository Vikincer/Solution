package pers.rokin.IO;

import java.io.*;

/*
* 字符流的由来：
* 因为数据编码的不同，而有了对字符进行高效操作的流对象。
* 本质其实就是基于字节流读取时，去查了指定的码表。字节流和字符流的区别：
    1、读写单位不同：字节流以字节（8bit）为单位，字符流以字符为单位，根据码表映射字符，一次可能读多个字节。
    2、处理对象不同：字节流能处理所有类型的数据（如图片、avi等），而字符流只能处理字符类型的数据。
    3、字节流在操作的时候本身是不会用到缓冲区的，是文件本身的直接操作的；
      而字符流在操作的时候下后是会用到缓冲区的，是通过缓冲区来操作文件，我们将在下面验证这一点。
结论：
* 优先选用字节流。
* 首先因为硬盘上的所有文件都是以字节的形式进行传输或者保存的，包括图片等内容。
* 但是字符只是在内存中才会形成的，
* 所以在开发中，字节流使用广泛。

* 对输入流只能进行读操作，对输出流只能进行写操作，
* 程序中需要根据待传输数据的不同特性而使用不同的流。

* * */

public class IOTest {
    private static final String const_filePath="D:\\Hword\\java\\java_project\\javaee\\src\\pers\\rokin\\IO\\test.txt";
    private static final String const_filePathChinese="D:\\Hword\\java\\java_project\\javaee\\src\\pers\\rokin\\IO\\中文.txt";
    private File const_file = null;
    private File const_fileChinese = null;

    public static void main(String[] args) {
        charTest01();
    }
    public IOTest(){
        this.const_file = new File(const_filePath);
        this.const_fileChinese = new File(const_filePathChinese);
    }

    //字节流读取文件：单个字符读取
    public static void byteTest01(boolean b_chinese_file){
        IOTest ioTest = new IOTest();
        FileInputStream fis = null;
        try {
            if (true == b_chinese_file) {
                //测试字节流读取中文乱码问题
                fis = new FileInputStream(ioTest.const_fileChinese);
            } else {
                fis = new FileInputStream(ioTest.const_file);
            }
            int read = 0;
            while((read = fis.read()) != -1){
                log((char)read,false);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 字节流读取文件：数组循环读取
    private static byte[] byteTest02() {
        IOTest ioTest = new IOTest();
        FileInputStream fis = null;
        int len = 512;
        byte[] buffer = new byte[len];
        try {
            fis = new FileInputStream(ioTest.const_file);
            int read;
            while ((read = fis.read(buffer,0,len)) != -1) {
                log(buffer + "", true, false);
            }
            for(byte b : buffer) {
                if(true == Character.isLetterOrDigit((char)b) || (char)b == '\n') {
                    log((char)b, false, false);
                }
            }
        } catch (FileNotFoundException e) {
            return new byte[1];
        } catch (IOException e) {
            return new byte[1];
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }
    /**
     * 字节流写操作
     * @throws IOException
     * @throws FileNotFoundException
     */
    private static void byteTest03() {
        String outPath = "D:\\Hword\\java\\java_project\\javaee\\src\\pers\\rokin\\IO\\testNew.txt";
        FileOutputStream fos = null;
        try {
            File file = new File(outPath);
            byte[] buffer = byteTest02();
            fos = new FileOutputStream(file);
            fos.write(buffer);
        } catch (FileNotFoundException e) {
            log("FileNotFoundException: " + e);
        } catch (IOException e) {
            log("IOException: " + e);
        } finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // * 字符流读取中文文档，解决字节流读取中文乱码问题
    private static void charTest01() {
        IOTest ioTest = new IOTest();
        FileReader fr = null;
        try {
            fr = new FileReader(ioTest.const_fileChinese);
            int read = 0;
            while ((read = fr.read()) != -1) {
                log((char) read, false);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 字符流写操作
     * @throws IOException
     * @throws FileNotFoundException
     */
    private static void test05() {
        String outPath = "D:\\Hword\\java\\java_project\\javaee\\src\\pers\\rokin\\IO\\中文New.txt";
        IOTest ioTest = new IOTest();
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(ioTest.const_fileChinese);
            StringBuilder sb = new StringBuilder();

            int read = 0;
            while ((read = fr.read()) != -1) {
                log((char)read, false);
                sb.append((char)read);
            }

            File file = new File(outPath);
            fw = new FileWriter(file);
            fw.write(sb.toString());
        } catch (FileNotFoundException e) {
            log("FileNotFoundException: " + e);
        } catch (IOException e) {
            log("IOException: " + e);
        } finally {
            if(fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void log(Object msg, boolean b_wrap) {
        if(true == b_wrap) {
            System.out.println(msg + "");
        }else {
            System.out.print(msg + "");
        }
    }

    private static void log(Object msg) {
        log(msg, true, true);
    }

    /**
     * @param msg 带输出信息
     * @param b_wrap 是否换行
     * @param out 是否输出
     */
    private static void log(Object msg, boolean b_wrap, boolean out) {
        if (true == out) {
            if (true == b_wrap) {
                System.out.println(msg + "");
            } else {
                System.out.print(msg + "");
            }
        }
    }




}
