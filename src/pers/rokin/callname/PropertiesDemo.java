package pers.rokin.callname;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
//        myStore();
//        myLoad();

    }

    private static void myLoad() throws IOException {
        Properties properties = new Properties();

        FileReader fr = new FileReader("D:\\Hword\\java\\java_project\\src\\pers\\rokin\\callname\\Properties.txt");
        properties.load(fr);
        fr.close();

        System.out.println(properties);
    }

    private static void myStore() throws IOException {


        Properties properties = new Properties();
        properties.setProperty("编码001", "常山赵子龙");
        properties.setProperty("编码002", "刘备字玄德");
        properties.setProperty("编码003", "诸葛亮字孔明");

        FileWriter wf = new FileWriter("D:\\Hword\\java\\java_project\\src\\pers\\rokin\\callname\\Properties.txt");
        properties.store(wf,null);
        wf.close();
    }

}
