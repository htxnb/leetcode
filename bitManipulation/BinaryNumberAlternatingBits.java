package leetcode.bitManipulation;

/**
 * 问题描述：
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * 示例 1:
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 示例 2:
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 示例 3:
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 *  示例 4:
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 * @ClassName BinaryNumberAlternatingBits
 * @Author htx
 * @Date 2018/9/19 20:15
 * @Version 1.0
 **/
public class BinaryNumberAlternatingBits {
    public static boolean hasAlternatingBits(int n) {
        int flag = -1;
        while(n > 0){
            if(n % 2 == 1){
                if(flag == 1){
                    return false;
                }
                flag = 1;
                n = n >> 1;
            }else{
                if(flag == 0){
                    return false;
                }
                flag = 0;
                n = n >> 1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
    }
}
