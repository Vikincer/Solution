package pers.rokin.algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题一
 *
 * 描述
 * 请你实现一个栈。
 * 操作：
 * push x：将 加x 入栈，保证 x 为 int 型整数。
 * pop：输出栈顶，并让栈顶出栈
 * top：输出栈顶，栈顶不出栈
 * 输入描述：
 * 第一行为一个正整数 n\n ，代表操作次数。(1 \leq n \leq 100000)(1≤n≤100000)
 * 接下来的 n\n ，每行为一个字符串，代表一个操作。保证操作是题目描述中三种中的一种。
 *
 *
 * 输出描述：
 * 如果操作为push，则不输出任何东西。
 * 如果为另外两种，若栈为空，则输出 "error“
 * 否则按对应操作输出。
 */

public class StackDemo {
    private static Stack stack = new Stack();
    public static void main(String [] args){
//        timu1();
        
//        int [] a = {-6,15,4,17,7,14,0,9,13,16,18,10,3,1,2,19,8,12,5,11};
//        int [] b = {-6,17,4,15,14,7,9,18,16,13,0,10,1,3,19,2,8,11,5,12};
//        boolean b1 = timu2(a, b);
//        System.out.println(b1);

//        String s = "()[]{}";
//        boolean b = timu3(s);
//        System.out.println(b);

//        String [] s = {"2","1","+","4","*"};
//        int i = timu4(s);
//        System.out.println(i);

        String s = "abbc";
        String s1 = timu5(s);
        System.out.println(s1);


    }
    public static void timu1(){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i=0; i<=N; i++){   //此处循环要多加一层 因为nextLine方法跳过一层
            check(scanner.nextLine());
        }
        scanner.close();
    }
    public static void check(String context){
        String[] target = context.split(" ");
        if(target[0].equals("pop")){
            pop();
        }else if(target[0].equals("top")){
            top();
        }else if(target[0].equals("push")){
            System.out.println("???" + Arrays.toString(target));
            push(Integer.parseInt(target[1]));
        }
    }
    public static void pop(){
        if(!stack.isEmpty()){
            System.out.println(stack.pop());
        }else{
            System.out.println("error");
        }
    }
    public static void top(){
        if(!stack.isEmpty()){
            System.out.println(stack.peek());
        }else{
            System.out.println("error");
        }
    }
    public static void push(int i){
        stack.push(i);
    }

    /**
     * 题 二
     *
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，
     * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
     * 1. 0<=pushV.length == popV.length <=1000
     * 2. -1000<=pushV[i]<=1000
     * 3. pushV 的所有数字均不相同
     */


    public static boolean timu2(int[] pushA, int[] popA) {
            int n = pushA.length;
            //辅助栈
            //遍历入栈的下标
            int j = 0;
            //遍历出栈的数组
            for(int i = 0; i < n; i++){
                //入栈：栈为空或者栈顶不等于出栈数组
                while(j < n && (stack.isEmpty() || (int)stack.peek() != popA[i])){
                    stack.push(pushA[j]);
                    j++;
                }
                //栈顶等于出栈数组
                if((int)stack.peek() == popA[i])
                    stack.pop();
                    //不匹配序列
                else
                    return false;
            }
            return true;
    }

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 */

    public static boolean timu3(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i<chars.length; i++){
            if(chars[i] == '(')
                stack.push(')');
            else if(chars[i] == '{')
                stack.push('}');
            else if(chars[i] == '[')
                stack.push(']');
            else if(stack.isEmpty() && (Character) stack.pop() != chars[i])
                return false;
        }
        return stack.isEmpty();
    }

    /**
     * 题 四
     *
     * 给定一个逆波兰表达式，求表达式的值。
     */
    public static int timu4(String[] tokens){
        int result = 0;
        for (int i =0; i< tokens.length; i++){
            if(tokens[i].equals("+")) {
                result = (int)stack.pop() + (int)stack.pop();
                stack.push(result);
            }else if(tokens[i].equals("-")) {
                int num1 = (int)stack.pop();
                int num2 = (int)stack.pop();
                result =  num2 - num1;
                stack.push(result);
            }else if(tokens[i].equals("*")) {
                result = (int)stack.pop() * (int)stack.pop();
                stack.push(result);
            }else if(tokens[i].equals("/")) {
                int num1 = (int)stack.pop();
                int num2 = (int)stack.pop();
                result =  num2 / num1;
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return (int)stack.peek();
    }

    /**
     * 题 五
     *
     * 牛牛拿到了一个字符串。
     * 他每次“点击”，可以把字符串中相邻两个相同字母消除，例如，字符串"abbc"点击后可以生成"ac"。
     * 但相同而不相邻、不相同的相邻字母都是不可以被消除的。
     * 牛牛想把字符串变得尽可能短。他想知道，当他点击了足够多次之后，字符串的最终形态是什么？
     */

    public static String timu5(String arg){
        for (int i =0; i<arg.length(); i++){
            if(stack.isEmpty() || arg.charAt(i) != (Character) stack.peek())
                stack.push(arg.charAt(i));
            else
                stack.pop();
        }
        String result = "";
        while(!stack.isEmpty()){
            char i = (Character) stack.pop();
            result += i;
        }
        StringBuilder stringBuilder = new StringBuilder(result);
        return result==""?"0":stringBuilder.reverse().toString();
    }
}
