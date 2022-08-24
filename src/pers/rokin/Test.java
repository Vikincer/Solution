package pers.rokin;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    static int i;
    private static String makeNum(){
        Random random = new Random();
        String num = random.nextInt(999999) + "";
        return num;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int nums [] = {x,y,z};
        for (int i = 0; i<nums.length-1; i++){
            for (int j = 0; j<nums.length-1; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for(int num : nums){
            System.out.print(num);
        }


    }
    public static void num(int n){
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i<=n; i++){
            sb.append(i);
        }
        String str1 = sb.toString();
        String str2 = str1.replaceAll("[0|2|3|4|5|6|7|8|9]", "");
        System.out.println(str2.length());

    }
    public static void stackTest(){
        String s1 = "abc";
        String s2 = "def";
        Stack stack = new Stack();
        stack.push(s1);
        stack.push(s2);
        Object pop = stack.pop();
        Object peek = stack.peek();
        System.out.println(stack);

    }
}
