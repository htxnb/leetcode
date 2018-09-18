package leetcode;

/**问题描述：
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母
 * @ClassName WordPattern
 * @Author htx
 * @Date 2018/9/12 19:16
 * @Version 1.0
 **/
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        char[] chars = pattern.toCharArray();
        if(chars.length != strings.length){
            return false;
        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                if(chars[i] == chars[j] && strings[i].equals(strings[j])){
                    continue;
                }else if(chars[i] != chars[j] && !strings[i].equals(strings[j])){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
