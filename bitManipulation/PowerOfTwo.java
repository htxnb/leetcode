package leetcode.bitManipulation;

/**
 * 问题描述：
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 * 输入: 218
 * 输出: false
 * @ClassName PowerOfTwo
 * @Author htx
 * @Date 2018/9/19 22:10
 * @Version 1.0
 **/
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 ? (n & (n - 1)) == 0 : false ;
    }
}
