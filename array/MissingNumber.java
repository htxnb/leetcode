package leetcode.array;

/**
 * 问题描述：
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * @ClassName MissingNumber
 * @Author htx
 * @Date 2018/9/10 11:00
 * @Version 1.0
 **/
public class MissingNumber {
    /**
     * 异或：1异或任何数 = 任何数取反
     * 0异或任何数 = 任何数
     * 任何数异或自己 = 把自己置为0
     * 示例：(a^b^c) ^(a^b) = c 相当于 (a^a)^(b^b)^c = 0^0^c = c
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^=  nums[i] ^ (i+1);
        }
        return result;
    }


}
