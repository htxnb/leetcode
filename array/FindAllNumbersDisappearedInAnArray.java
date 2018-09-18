package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：
 *给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *  找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *  您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *  示例:
 *  输入:
 *  [4,3,2,7,8,2,3,1]
 *  输出:
 *  [5,6]
 * @ClassName FindAllNumbersDisappearedInAnArray
 * @Author htx
 * @Date 2018/9/15 21:35
 * @Version 1.0
 **/
public class FindAllNumbersDisappearedInAnArray {
    /**
     * 采用桶结构，时间复杂度为0(n),空间复杂度为O(n)
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] ints = new int[nums.length+1];
        ArrayList<Integer> arrayList = new ArrayList<>(nums.length/2);
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]] = nums[i];
        }
        for (int i = 0; i < ints.length; i++) {
            if(ints[i] != i){
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] ints = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(ints));
    }
}
