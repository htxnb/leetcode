package leetcode.string;

/**
 * 问题描述：
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * 示例 1：
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 * 输入: "LOVELY"
 * 输出: "lovely"
 * @ClassName ToLowerCase
 * @Author htx
 * @Date 2018/9/19 16:25
 * @Version 1.0
 **/
public class ToLowerCase {
    /**
     * unicode编码中包含了ascii编码，A-Z编码十进制为65-90，a-z编码十进制为97-122，
     * 对应大写字母的编码比小写字母小32
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        str = "";
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 65 && chars[i] <= 90){
                chars[i] = (char) (chars[i] + 32);
            }
            str += chars[i];
        }
        return str;
    }

    public static void main(String[] args) {
        String asSe = toLowerCase("ASSe");
        System.out.println(asSe);
    }
}
