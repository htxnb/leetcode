package leetcode.array;

/**
 * 问题描述：
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 * 示例 1:
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 * 示例 2:
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 * 提示:
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 99].
 * @ClassName LargerNumeberAtLeastTwiceOFOthers
 * @Author htx
 * @Date 2018/9/15 21:47
 * @Version 1.0
 **/
public class LargerNumeberAtLeastTwiceOFOthers {
    /**
     * 一次遍历，用数组来保存最大值和第二大值，时间复杂度O(n)，空间复杂度O(1)
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {
        int[] max = new int[2];
        max[0] = Integer.MIN_VALUE;
        max[1] = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(max[1] <= nums[i]) {
                max[0] = max[1];
                max[1] = nums[i];
                maxIndex = i;
            }else {
                //若最大值在最后一位，则此操作没有意义；但最大值不在最后一位时，
                // 较小的值不会保存到max中，secondmax中的值也就不会更新，所以需要额外更新一次
                max[0] = Math.max(max[0],nums[i]);
            }

        }
        if(max[1] >= max[0] * 2){
            return maxIndex;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] ints = {0,0,1,2};
        System.out.println(dominantIndex(ints));
    }
}
