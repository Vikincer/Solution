package pers.rokin.fight_against_landlords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SortPoker {
    public static void main(String[] args) {
    //创建扑克
    String [] colors = {"♦","♣","♥","♠"};
    String [] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
    HashMap <String, Integer> cardHM = new HashMap<String, Integer>();
    ArrayList <String> cardAL= new ArrayList<String>();
    int index = 0;
    for (String number : numbers){
        for (String color : colors){
            cardHM.put(number+color,index);
            cardAL.add(number+color);
            index++;
        }
    }
        System.out.println(cardHM);
    //洗牌
    Collections.shuffle(cardAL);

    for (int i = 0; i<cardAL.size()-1; i++){
        for (int j = 0; j<cardAL.size()-1-i; j++){
            if(cardHM.get( cardAL.get(j) ) > cardHM.get( cardAL.get(j+1) )){
                String temp = cardAL.get(j);
                cardAL.set(j,cardAL.get(j+1));
                cardAL.set(j+1,temp);
            }
        }
    }
        System.out.println(cardAL);

    }
}
