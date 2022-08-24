package pers.rokin.internet.TCPFile;

import java.io.*;
import java.net.Socket;

public class TCPCliect {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.19.15.139",2233);

        //封装键盘写入
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //封装文本文件的数据
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Hword\\java\\java_project\\src\\pers\\rokin\\internet\\TCPFile\\copy.txt"));


        //封装输出流对象
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        while((line=bufferedReader.readLine()) != null){
//            if("886".equals(line))        //键盘输入的操作
//                break;
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        //结束标记
//        socket.shutdownOutput();

        //接收反馈
//        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String data = bufferedReader1.readLine();
//        System.out.println("服务器的反馈是：" + data);

        socket.close();
    }
}
