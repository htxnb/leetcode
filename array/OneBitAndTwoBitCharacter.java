package leetcode.array;

/**
 * 问题描述：
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 * 示例 1:
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 * 示例 2:
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 * 注意:
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 * @ClassName OneBitAndTwoBitCharacter
 * @Author htx
 * @Date 2018/9/18 12:02
 * @Version 1.0
 **/
public class OneBitAndTwoBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        boolean isOneBit = false;
        int current = 0;
        while(current < bits.length){
            if(bits[current] == 0){
                isOneBit = true;
                current++;
            }else if(bits[current] == 1){
                isOneBit = false;
                current += 2;
            }
        }

        return isOneBit;
    }
}
