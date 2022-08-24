package pers.rokin.internet.UDPchatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPSend {
    public static void main(String[] args) throws IOException {
        //创建发送端
        DatagramSocket person = new DatagramSocket();

        //键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while((line = br.readLine()) != null){
            if("886".equals(line))
                break;
            byte [] buf = line.getBytes();
            //创建数据包
            DatagramPacket data = new DatagramPacket(buf,buf.length, InetAddress.getByName("192.168.137.1"),2233);
            //发送数据包
            person.send(data);
        }

        person.close();
        br.close();

    }
}
