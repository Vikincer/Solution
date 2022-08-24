package pers.rokin.internet.TCPThread;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable{
    private Socket s;
    public ServerThread(Socket s ){
        this.s = s;
    }
    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Hword\\java\\java_project\\src\\pers\\rokin\\internet\\TCPThread\\test.txt"));

            String line;
            while((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

            //给出反馈
            BufferedWriter bufferedServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bufferedServer.write("文件上传成功");
            bufferedServer.newLine();
            bufferedServer.flush();

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
