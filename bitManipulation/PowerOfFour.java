package leetcode.bitManipulation;

/**
 * 问题描述：
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * 示例 1:
 * 输入: 16
 * 输出: true
 * 示例 2:
 * 输入: 5
 * 输出: false
 * @ClassName PowerOfFour
 * @Author htx
 * @Date 2018/9/19 22:10
 * @Version 1.0
 **/
public class PowerOfFour {
    public static boolean isPowerOfFour(int num) {
        if(num == 1){
            return true;
        }
        if((num & (num-1)) != 0 || num < 0){
            return false;
        }
        int number = 0;
        while(num > 0){
            number++;
            num = num >> 1;
        }
        return (number & 1) == 1;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfFour(6));
    }
}
