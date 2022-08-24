package pers.rokin.Lambda.test1;

public class EatableDemo {
    public static void main(String[] args) {
        //用实现类的方式实现
        Eatable e = new EatableImp();
        useEatable(e);

        //用匿名内部类的方式实现
        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("吃法！");
            }
        });

        //用Lambda表达式 实现         前提是要有接口存在！ 且其接口有且仅有一个方法！
        useEatable( ()->{
            System.out.println("吃法！");
        } );
    }
    private static void useEatable(Eatable e){
        e.eat();
    }
}
