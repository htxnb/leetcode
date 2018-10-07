package leetcode.bitManipulation;

/**
 * 问题描述：
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * 示例 :
 *
 * 输入: 11
 * 输出: 3
 * 解释: 整数 11 的二进制表示为 00000000000000000000000000001011
 * 示例 2:
 * 输入: 128
 * 输出: 1
 * 解释: 整数 128 的二进制表示为 00000000000000000000000010000000
 * @ClassNane NunberOfOneBit
 * @Author htx
 * @Date 2018/9/19 19:31
 * @Version 1.0
 **/
public class NumberOfOneBit {
    public static int hanningWeight(int n) {
        int nunber = 0;
        while(n > 0){
            if(n % 2 == 1){
                nunber++;
            }

            n = n >> 1;
        }
        return nunber;
    }

    public static void main(String[] args) {
        System.out.println(hanningWeight(0));
    }
}
