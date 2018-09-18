package leetcode.array;

import java.util.Arrays;

/**
 * 问题描述：
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * 提示：
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * @ClassName SortByParity
 * @Author htx
 * @Date 2018/9/18 11:04
 * @Version 1.0
 **/
public class SortByParity {
    public static int[] sortArrayByParity(int[] A) {
        int parity = -1;
        for (int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0){
              swap(A,i,++parity);
            }
        }
        return A;
    }

    public static void swap(int[] nums,int i,int j){
        if(i == j){
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] ints = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(ints)));
    }
}
