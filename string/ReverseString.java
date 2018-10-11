package leetcode.string;

/**
 * 问题描述：
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * 示例 1:
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 * @ClassName ReverseString
 * @Author htx
 * @Date 2018/9/19 16:42
 * @Version 1.0
 **/
public class ReverseString {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0,right = chars.length-1;
        while(left < right){
            swap(chars,left++,right--);
        }
        return new String(chars);
    }

    public void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
