package pers.rokin.internet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //创建客户端的Socket对象
//        Socket socket = new Socket(InetAddress.getByName("192.168.137.1"),2233);//写法1
        Socket socket = new Socket("192.168.137.1",2233);//写法2

        //获取输出流 写数据
        OutputStream os = socket.getOutputStream();
        os.write("HelloTCP".getBytes());

        os.close();
    }
}
