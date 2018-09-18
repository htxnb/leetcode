package leetcode.array;

/**
 * 问题描述：
 *
 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 示例:
 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 进阶:
 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解
 * @ClassName MaximumSubArray
 * @Author htx
 * @Date 2018/9/17 15:48
 * @Version 1.0
 **/
public class MaximumSubArray {
    /**
     * 动态规划,时间复杂度O(n)
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0,result = nums[0];
        for (int i = 0 ; i < nums.length ; i++) {
            sum = Math.max(sum+nums[i],nums[i]);
            result = Math.max(sum,result);
        }
        return result;
    }

    /**
     * 分治，时间复杂度O(nlogn)
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums,int left,int right) {
        if(left == right){
            return nums[left];
        }
        int leftMax,rightMax,
                leftBorderSum = 0,rightBorderSum = 0,
                leftBorderMax = Integer.MIN_VALUE,rightBorderMax = Integer.MIN_VALUE;
        int mid = left + ((right - left) >> 1);
        leftMax = maxSubArray2(nums, left, mid);
        rightMax = maxSubArray2(nums, mid+1, right);

//        计算mid左边的最大子序列
        for (int i = mid; i >=left ; i--) {
            leftBorderSum += nums[i];
            leftBorderMax = Math.max(leftBorderMax,leftBorderSum);
        }
//        计算mid右边的最大子序列
        for (int i = mid+1; i <= right; i++) {
            rightBorderSum += nums[i];
            rightBorderMax = Math.max(rightBorderMax,rightBorderSum);
        }

//        比较左边最大子序列，右边最大子序列，包括mid的最大子序列
        return max(leftMax,rightMax,leftBorderMax+rightBorderMax);
    }

    /**
     * 得到三个Int值中的最大值
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int max(int a,int b,int c){
        int temp = Math.max(a,b);
        return Math.max(temp,c);
    }


    public static void main(String[] args) {
        int[] ints = {-2,-1};
        System.out.println(maxSubArray2(ints,0,1));
    }



}
