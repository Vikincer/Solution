package pers.rokin.internet.TCPchatroom;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2233);

        Socket socket = serverSocket.accept();

//        InputStream inputStream = socket.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader br = new BufferedReader(inputStreamReader);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while((line=br.readLine())!= null){
            System.out.println(line);
        }
        socket.close();
    }
}
