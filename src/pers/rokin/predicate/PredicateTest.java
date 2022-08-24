package pers.rokin.predicate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class PredicateTest {
    static Map<String, Object> hashMap = new HashMap<String, Object>();
    public static void main(String[] args) {
//        helloPredicate();
        compare();
    }
    public static void helloPredicate(){
        // 利用函数式接口
        Predicate<String> predicate = (String t)-> t.equals("zs");
        boolean test = predicate.test("ls");
        System.out.println(test);
        boolean test2 = predicate.test("zs");
        System.out.println(test2);
    }
    /*
* 一些常见的比较
// 判断传入的字符串的长度是否大于5
// 判断传入的数字是否大于0
// 判断传入的值在hash中是否存在
* */
    private static <T> boolean judgeByPredicate(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }
    private static void compare() {
        boolean judgeByPredicate = judgeByPredicate("zhangsan", t -> t.length() > 5);
        System.out.println(judgeByPredicate);

        boolean judgeByPredicate2 = judgeByPredicate(10,t -> t > 0);
        System.out.println(judgeByPredicate2);

        hashMap.put("zs", 18);
        hashMap.put("ls", 28);
        hashMap.put("ww", 38);

        boolean judgeByPredicate3 = judgeByPredicate("zs1", t -> hashMap.containsKey(t));
        System.out.println(judgeByPredicate3);
    }

}
