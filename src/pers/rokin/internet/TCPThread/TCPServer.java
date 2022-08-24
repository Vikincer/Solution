package pers.rokin.internet.TCPThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2233);

        while(true){
            Socket s = serverSocket.accept();
            //为每一个客户端开启一个线程
            new Thread(new ServerThread(s)).start();
        }
    }
}
