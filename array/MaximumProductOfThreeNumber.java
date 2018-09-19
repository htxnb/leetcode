package leetcode.array;

import java.util.Arrays;

/**
 * 问题描述：
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * @ClassName MaximumProductOfThreeNumber
 * @Author htx
 * @Date 2018/9/15 21:42
 * @Version 1.0
 **/
public class MaximumProductOfThreeNumber {
    /**
     * 利用快排进行排序，时间复杂度为0(nlogn)，空间复杂度为0(1)
     * @param nums
     * @return
     */
    public  static int maximumProduct(int[] nums) {
        if(nums.length == 3){
            return nums[0]*nums[1]*nums[2];
        }
        int minusMax = 0,plusMax = 0,max = 0;
        quickSort(nums,0,nums.length-1);
        minusMax = nums[0] * nums[1];
        plusMax = nums[nums.length-3] * nums[nums.length-2];
        max = nums[nums.length-1];
        return plusMax > minusMax ? plusMax * max: minusMax * max;

    }

    public static void quickSort(int[] nums,int left,int right){
        if(left < right){
            int[] partition = partition(nums, left, right);
            quickSort(nums,left,partition[0]);
            quickSort(nums,partition[1],right);
        }
    }

    public static int[] partition(int[] nums,int left,int right){
        int less = left - 1,more = right + 1,current = left;
        int compared = nums[right];
        while(current < more){
            if(nums[current] < compared){
                swap(nums,current++,++less);
            }else if(nums[current] > compared){
                swap(nums,current,--more);
            }else{
                current++;
            }
        }
        return new int[]{less,more};

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
        int[] ints = {7,3,1,0,0,6};
        quickSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }
}
