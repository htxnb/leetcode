package leetcode.string;


import java.util.HashMap;

/**
 * 问题描述：
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-.-....-"，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 * 返回我们可以获得所有词不同单词翻译的数量。
 * 例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 * 注意:
 * 单词列表words 的长度不会超过 100。
 * 每个单词 words[i]的长度范围为 [1, 12]。
 * 每个单词 words[i]只包含小写字母。
 * @ClassName UniqueMorseCodeWords
 * @Author htx
 * @Date 2018/9/21 22:38
 * @Version 1.0
 **/
public class UniqueMorseCodeWords {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<Character, String> hashMap = new HashMap<>(26);
        HashMap<String,Integer> results = new HashMap<>();
        int current = -1;
        for (int i = 97; i <= 122; i++) {
            hashMap.put((char)i,code[++current]);
        }

        System.out.println(hashMap);
        for (int i = 0; i < words.length; i++) {
            String trans = translate(words[i],hashMap);
            if(!results.containsKey(trans)){
                results.put(trans,1);
            }else{
                results.replace(trans,results.get(trans));
            }
        }

        return results.size();


    }

    private static String translate(String word, HashMap<Character, String> hashMap) {
        char[] chars = word.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(hashMap.get(chars[i]));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"gin", "zen", "gig", "msg"};
        int i = uniqueMorseRepresentations(strings);
        System.out.println(i);
    }
}
