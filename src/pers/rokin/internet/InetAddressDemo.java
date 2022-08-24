package pers.rokin.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress address = InetAddress.getByName("Clay-master.mshome.net");
        InetAddress address = InetAddress.getByName("192.168.137.1");       //一般推荐这种

        String name = address.getHostName();
        String ip = address.getHostAddress();

        System.out.println("主机名：" + name);
        System.out.println("主机ip：" + ip);
    }
}
