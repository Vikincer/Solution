package pers.rokin.internet.TCPThread;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.19.15.139",2233);


//        封装文本文件的数据
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Hword\\java\\java_project\\src\\pers\\rokin\\internet\\TCPFile\\copy.txt"));

        //封装输出流对象
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        while((line=bufferedReader.readLine()) != null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        //结束标记
        socket.shutdownOutput();

        //接收反馈
        BufferedReader bufferedClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String data = bufferedClient.readLine();
        System.out.println("服务器的反馈是：" + data);

        bufferedReader.close();
        socket.close();
    }
}
