package pers.rokin.internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceive {
    public static void main(String[] args) throws IOException {
        //创建接收端
        DatagramSocket datagramSocket = new DatagramSocket(2233);

        //创建接收的数据包
        byte [] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length);

        //用DatagramSocket对象接收数据
        datagramSocket.receive(datagramPacket);

        //解析数据包
        byte [] data = datagramPacket.getData();
        String dataString = new String(data,0,datagramPacket.getLength());
        System.out.println("数据是：" + dataString);

        //关闭接收端
        datagramSocket.close();
    }
}
