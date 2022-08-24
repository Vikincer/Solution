package pers.rokin.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
* stream和parallelStream的简单区分：
* stream是顺序流，由主线程按顺序对流执行操作，
* parallelStream是并行流，内部以多线程并行执行的方式对流进行操作，但前提是流中的数据处理没有顺序要求。
* */

public class StreamTest {
    static List<Person> personList = new ArrayList<Person>();
    public static void main(String[] args) {
//        look();
//        findOne();
//        findLong();
        combination();
    }
    private static void initPerson() {
        personList.add(new Person("张三", 8, 3000));
        personList.add(new Person("李四", 18, 5000));
        personList.add(new Person("王五", 28, 7000));
        personList.add(new Person("孙六", 38, 9000));
    }
    public static void create(){
        List<String> list = Arrays.asList("a","b","c");
        Stream<String> listStream = list.stream();

        int [] intarr = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(intarr);

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream2.forEach(System.out::println);

        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);
    }
    //遍历/匹配（foreach/find/match）
    public static void look(){
// import已省略，请自行添加，后面代码亦是
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println);
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 6);
        System.out.println("匹配第一个值：" + findFirst.get());
        System.out.println("匹配任意一个值：" + findAny.get());
        System.out.println("是否存在大于6的值：" + anyMatch);
    }
    //获取String集合中最长的元素
    public static void findLong(){
        List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu", "sunliu");
        Comparator<? super String> comparator = Comparator.comparing(String::length);
        Optional<String> max = list.stream().max(comparator);
        System.out.println(max);
    }

    //筛选员工中未满18周岁的人，并形成新的集合
    public static void findOne(){
        initPerson();
        List<Person> collect = personList.stream().filter(x -> x.getAge() < 18).collect(Collectors.toList());
        System.out.println(collect);
    }

    /*
    * map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
    * flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
    * */
    //每个元素都加上一个固定值
    public static void addnum(){
        List<Integer> list = Arrays.asList(1, 17, 27, 7);
        List<Integer> collect = list.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println(collect);
    }
    //每人增薪2000
    private static void addsalary() {
        initPerson();
        List<Person> collect = personList.stream().map(x -> {
            x.setAge(x.getSalary()+2000);
            return x;
        }).collect(Collectors.toList());
        System.out.println(collect);
    }
    /*
     * 将两个字符数组合并成一个新的字符数组
     */
    private static void combination() {
        String[] arr = {"z, h, a, n, g", "s, a, n"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
        List<String> collect = list.stream().flatMap(x -> {
            String[] array = x.split(",");
            Stream<String> stream = Arrays.stream(array);
            return stream;
        }).collect(Collectors.toList());
        System.out.println(collect);
    }
}
