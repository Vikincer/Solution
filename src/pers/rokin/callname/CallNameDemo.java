package pers.rokin.callname;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//实现读取文件 获取文件中的数据
public class CallNameDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Hword\\java\\java_project\\javase\\src\\pers\\rokin\\callname\\callname.txt"));

        ArrayList<String> arrayList = new ArrayList();
        String line;
        while ((line = bufferedReader.readLine()) != null)
            arrayList.add(line);

        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        System.out.println(arrayList.get(index));



    }
}
