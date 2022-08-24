package pers.rokin.internet.TCPDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建服务器Socket
        ServerSocket serverSocket = new ServerSocket(2233);

        //监听客户端连接
        Socket socket = serverSocket.accept();

        //获取输入流 读取数据 并吧数据显示在控制台
        InputStream is = socket.getInputStream();
        byte [] buf = new byte[1024];
        int len = is.read(buf);
        String data = new String(buf,0,len);
        System.out.println("服务器内容" + data);

        //给出反馈
        OutputStream os = socket.getOutputStream();
        os.write("数据已接收".getBytes());

        socket.close();
        serverSocket.close();
    }
}
