package pers.rokin.internet;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建服务器Socket对象
        ServerSocket serverSocket = new ServerSocket(2233);

        //Socket accept() 侦听要连接到此处并接受它
        Socket socket = serverSocket.accept();

        //获取输入流
        InputStream is = socket.getInputStream();
        byte [] buf = new byte[1024];
        int len = is.read(buf);
        String data = new String(buf,0,len);
        System.out.println("数据是：" + data);

        socket.close();
        serverSocket.close();
        is.close();

    }
}
