package pers.rokin.Lambda.test2;

public class FlyableImp implements Flyable{
    @Override
    public void Fly(String s) {
        System.out.println(s + "可以飞！");
    }
}
