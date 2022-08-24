package pers.rokin.Num;

import java.util.Random;
import java.util.Scanner;

public class GameNum {
    private GameNum(){}
    public static void start(){
        //生成随机数 1-100
        Random r = new Random();
        int number = r.nextInt(100)+1;
//        System.out.println("答案" + number);
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你要猜的数字：");
            int guessnum = scanner.nextInt();

            if(guessnum > number){
                System.out.println("你猜的数字" + guessnum +"大了");
            }else if (guessnum < number){
                System.out.println("你猜的数字" + guessnum +"小了");
            }else{
                System.out.println("恭喜你 猜中了！");
                break;
            }
        }
    }
}
