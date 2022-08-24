package pers.rokin.Lambda.test2;

public class FlyableDemo {
    public static void main(String[] args) {
        //实现类的方法实现
        Flyable flyable = new FlyableImp();
        useFlyable(flyable);

        //内部类的方法实现
        useFlyable(new Flyable() {
            @Override
            public void Fly(String s) {
                System.out.println(s + "可以飞");
            }
        });

        //Lambda表达式 方法实现
        useFlyable( s -> System.out.println(s + "可以飞") );
    }
    private static void useFlyable(Flyable f){
        f.Fly("小鸟");
    }
}
