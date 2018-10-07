package leetcode.dynamicProgramming;

/**
 * 问题描述：
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * 示例 1:
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 * 输入的字符串长度不会超过1000
 * @ClassName PalindromicSubstrings
 * @Author htx
 * @Date 2018/10/6 15:36
 * @Version 1.0
 **/
public class PalindromicSubstrings {
    /**
     * 对于一个长度为n的字符串，
     * 回文子串个数 = 长度为n-1的子字符串的回文子串个数 + 以chars[n-1]为结尾的回文子串个数 + 1
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int[] subStringLength = new int[chars.length];
        subStringLength[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            int length = countLength(chars,i);
            subStringLength[i] = length + 1 + subStringLength[i-1];
        }
        return subStringLength[chars.length-1];
    }

    private static int countLength(char[] chars, int i) {
        int current = i-1,subStringLength = 0;

        while(current >= 0){
            int left = 0,right = 0;
            if(chars[current] == chars[i]){
                left = current;
                right = i;
                while(left < right){
                    if(chars[left] == chars[right]){
                        left++;
                        right--;
                        continue;
                    }else{
                        break;
                    }
                }

                if(left >= right){
                    subStringLength++;
                }
            }

            current--;
        }
        return subStringLength;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
