package pers.rokin.Lambda.test3;

public class AddableDemo {
    public static void main(String[] args) {
        useAddable( (int x, int y)->{   //参数类型可以省略 但是有多个参数的情况下 不能只省略一个！  且 如果参数有且仅有一个 小括号也可以省略！
            return x+y;         //如果代码块的语句只有一条 可以省略大括号和分号！（如果有return  return也要删掉 ） -> line 9
        } );

//        useAddable( (x,y) -> x+y );
    }
    private static void useAddable(Addable a){
        int sum = a.add(10,20);
        System.out.println(sum);
    }
}
