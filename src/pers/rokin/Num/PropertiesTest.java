package pers.rokin.Num;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {

        //获取本地文件game.txt 中count的值
        Properties properties = new Properties();
        FileReader fr = new FileReader("D:\\Hword\\java\\java_project\\src\\pers\\rokin\\Num\\game.txt");
        properties.load(fr);
        fr.close();
        int number = Integer.parseInt(properties.getProperty("count"));//根据 键 找到其对应的 值
//        System.out.println("number:  " + number);

        //判断游戏次数
        //超过三次将无法继续玩
        if(number >= 3){
            System.out.println("游戏已结束！");
        }else{
            GameNum.start();
            //游戏结束  游玩次数+1 并修改本地文件 game.txt中的count值
            number++;
            properties.setProperty("count", String.valueOf(number));
            FileWriter fw = new FileWriter("D:\\Hword\\java\\java_project\\src\\pers\\rokin\\Num\\game.txt");
            properties.store(fw,null);
            fw.close();
        }
    }
}
