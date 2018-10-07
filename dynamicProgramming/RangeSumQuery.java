package leetcode.dynamicProgramming;

/**
 * 问题描述：
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法
 * @ClassName RangeSumQuery
 * @Author htx
 * @Date 2018/9/25 14:53
 * @Version 1.0
 **/
public class RangeSumQuery {
    public int[] results = null;
    public int[] nums = null;
    public RangeSumQuery(int[] nums) {
        results = new int[nums.length];
        this.nums = nums;
        if (nums.length > 0){
            results[0] = nums[0];
            for(int i = 1;i<nums.length;i++){
                results[i] = results[i-1] + nums[i];
            }
        }

    }

    public int sumRange(int i, int j) {
        return results[j] - results[i] + nums[i];
    }
}
