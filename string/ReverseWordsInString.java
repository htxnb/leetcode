package leetcode.string;

/**
 * 问题描述：
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例 1:
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格
 * @ClassName ReverseWordsInString
 * @Author htx
 * @Date 2018/9/22 21:51
 * @Version 1.0
 **/
public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length - 1; i++) {
            String word = reverse(strings[i]);
            stringBuilder.append(word);
            stringBuilder.append(" ");
        }
        stringBuilder.append(reverse(strings[strings.length - 1]));
        return stringBuilder.toString();
    }

    private String reverse(String string) {
        char[] chars = string.toCharArray();
        int left = 0,right = chars.length - 1;
        while(left < right){
            swap(chars,left++,right--);
        }
        return new String(chars);
    }

    private void swap(char[] chars, int left, int right) {
        if(left == right){
            return;
        }
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;

    }
}
