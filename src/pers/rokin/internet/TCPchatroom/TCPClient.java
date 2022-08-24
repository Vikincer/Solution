package pers.rokin.internet.TCPchatroom;

import java.io.*;
import java.net.Socket;

//客户端直到发送886 才结束

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.173.1",2233);
//        Socket socket = new Socket("10.19.14.103",8088);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //封装输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        while((line=br.readLine()) != null){
            if("886".equals(line))
                break;
//            OutputStream os = socket.getOutputStream();
//            os.write(line.getBytes());
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        socket.close();
    }
}
