package pers.rokin.internet.UDPchatroom;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceive {
    public static void main(String[] args) throws IOException {
        //创建接收端
        DatagramSocket receive = new DatagramSocket(2233);

        //创建数据包
        byte [] buf = new byte[1024];
        DatagramPacket data = new DatagramPacket(buf,buf.length);
        while (true){
            //接收发送端数据 放入数据包
            receive.receive(data);

            //解析数据包
            System.out.println("数据是:" + new String( data.getData(),0, data.getLength()) );
        }

        //因为此处是死循环接收 所以不需要关闭
//        receive.close();
    }
}
