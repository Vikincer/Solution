package pers.rokin.fight_against_landlords;

//斗地主 前者的完善版本  在上一版的基础下实现排序


import java.util.*;

public class GamePoker {
    public static void main(String[] args) {
        //创建牌
        String [] colors = {"♦","♣","♥","♠"};
        String [] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        HashMap<Integer,String> cardMap = new HashMap<Integer,String>();
        ArrayList<Integer> cardList = new ArrayList<Integer>();
        int index = 0;
        for (String number : numbers){      //按牌的大小顺序储存
            for (String color : colors){
                cardMap.put(index,color+number);
                cardList.add(index);
                index++;
            }
        }
        cardMap.put(index,"小王");
        cardList.add(index);
        index++;
        cardMap.put(index,"大王");
        cardList.add(index);

        //洗牌
        Collections.shuffle(cardList);

        //发牌
        TreeSet<Integer> aCardSet = new TreeSet<Integer>();
        TreeSet<Integer> bCardSet = new TreeSet<Integer>();
        TreeSet<Integer> cCardSet = new TreeSet<Integer>();
        TreeSet<Integer> landCardSet = new TreeSet<Integer>();
        for (int i = 0; i<cardList.size(); i++){
            int poker = cardList.get(i);
            if(i>=cardList.size()-3){
                landCardSet.add(poker);
            }else if(i%3 == 0){
                aCardSet.add(poker);
            }else if(i%3 == 1){
                bCardSet.add(poker);
            }else if(i%3 == 2){
                cCardSet.add(poker);
            }
        }

        //看牌
        LookPoker("A玩家", aCardSet,cardMap);
        LookPoker("B玩家", bCardSet,cardMap);
        LookPoker("C玩家", cCardSet,cardMap);
        LookPoker("地主", landCardSet,cardMap);
    }

    public static void LookPoker(String name,TreeSet<Integer> ts, HashMap<Integer,String> hm){
        System.out.println(name + "的牌是: ");
        for (Integer key : ts){
            String poker = hm.get(key);
            System.out.print(poker+" ");
        }
        System.out.println("");
    }
}
