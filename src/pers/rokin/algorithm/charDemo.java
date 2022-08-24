package pers.rokin.algorithm;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 */

public class charDemo {
    public static void main(String args [] ){
        charDemo charDemos = new charDemo();
        charDemos.isValid("{}");
    }
    public boolean isValid (String s) {
        // write code here
        char[] chars = s.toCharArray();

        return true;
    }
}
