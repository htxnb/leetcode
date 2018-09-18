package leetcode.array;

import java.util.HashMap;

/**
 * 问题描述：
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * @ClassName InputSortedArray
 * @Author htx
 * @Date 2018/9/15 21:34
 * @Version 1.0
 **/
public class InputSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            hashMap.put(numbers[i],i);
        }

        for (int i = 0; i < numbers.length; i++) {
            if(hashMap.containsKey(target-numbers[i])){
                Integer integer = hashMap.get(target - numbers[i]);
                return new int[]{i+1,integer+1};
            }
        }
        return null;
    }
}
