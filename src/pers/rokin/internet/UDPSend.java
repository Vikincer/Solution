package pers.rokin.internet;

import java.io.IOException;
import java.net.*;

public class UDPSend {
    public static void main(String[] args) throws IOException {
        //创建发送端
        DatagramSocket datagramSocket = new DatagramSocket();

        //DatagramPacket(byte[] buf, int length, InetAddress address, int port)
        //构造一个数据包 发送长度为length的数据包到指定主机上的指定端口号
        byte [] buf = "Hello UDP".getBytes();
        int length = buf.length;
        InetAddress inetAddress = InetAddress.getByName("192.168.137.1");
        int port = 2233;
        DatagramPacket datagramPacket = new DatagramPacket(buf,length,inetAddress,port);

        //发送数据包
        datagramSocket.send(datagramPacket);

        //关闭发送端
        datagramSocket.close();


    }
}
