package pers.rokin.internet.TCPFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务器接收数据写入文件

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2233);

        Socket socket = serverSocket.accept();

        //接收数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //把数据写入文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Hword\\java\\java_project\\src\\pers\\rokin\\internet\\TCPFile\\test.txt"));
        String line;
        while((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //给出反馈
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        bufferedWriter.write("文件上传成功");
//        bufferedWriter.newLine();
//        bufferedWriter.flush();

        bw.close();
        serverSocket.close();
    }
}
