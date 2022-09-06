package pers.rokin.fight_against_landlords;

import java.util.ArrayList;
import java.util.Collections;

//实现 斗地主的洗牌 发牌 看牌  （基础 不完善版本）

public class GameFightLand {
    public static void main(String[] args) {
        //创建卡牌
        String [] colors = {"♦","♣","♥","♠"};
        int a = colors.length;
        String [] numbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        ArrayList<String> cards = new ArrayList<String>();
        for (String color : colors){
            for(String number : numbers){
                cards.add(color+number);
            }
        }
        cards.add("大王");
        cards.add("小王");
        
        

        //打乱排序并发牌给a，b，c三个玩家 并且将最后的三张放于底牌（地主牌）
        Collections.shuffle(cards);//打乱卡牌
        ArrayList<String> aCardlist = new ArrayList<String>();
        ArrayList<String> bCardlist = new ArrayList<String>();
        ArrayList<String> cCardlist = new ArrayList<String>();
        ArrayList<String> landmainCardlist = new ArrayList<String>();
        //发牌
        for (int i = 0; i<cards.size(); i++){
            String card = cards.get(i);
            if(i>=cards.size()-3){
                landmainCardlist.add(card);
            }else if(i%3 == 0){
                aCardlist.add(card);
            }else if(i%3 == 1){
                bCardlist.add(card);
            }else{
                cCardlist.add(card);
            }
        }
        System.out.println("a卡牌"+aCardlist);
        System.out.println("b卡牌"+bCardlist);
        System.out.println("c卡牌"+cCardlist);
        System.out.println("地主卡牌"+landmainCardlist);
//        System.out.println("卡牌："+cards);
    }
}
