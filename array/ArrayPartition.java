package leetcode.array;

import java.util.Arrays;

/**
 * 问题描述：
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * 示例 1:
 * 输入: [1,4,3,2]
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 * (1)n 是正整数,范围在 [1, 10000].
 * (2)数组中的元素范围在 [-10000, 10000].
 * @ClassName ArrayPartition
 * @Author htx
 * @Date 2018/9/10 10:51
 * @Version 1.0
 **/
public class ArrayPartition {
    /**
     * 只要将数组排序，相邻的两个元素差值最小，才能保证数组中大的数流失的不多
     * @param arr
     * @return
     */
    public int partition(int[] arr){
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i+=2) {
            sum += arr[i];
        }
        return sum;
    }
}
