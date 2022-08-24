package pers.rokin.internet.TCPDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //创建Scoket 对象
        Socket socket = new Socket("192.168.173.1",2233);

        //获取输出流 写数据
        OutputStream os = socket.getOutputStream();
        os.write("Hello TCP".getBytes());

        //接收服务器反馈
        InputStream is = socket.getInputStream();
        byte [] buf = new byte[1024];
        int len = is.read(buf);
        String data = new String(buf,0,len);
        System.out.println("客户端接收 服务器反馈内容 是：" + data);

        //关闭
        socket.close();
    }
}
