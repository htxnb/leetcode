package leetcode.array;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * @ClassName TwoSum
 * @Author htx
 * @Date 2018/9/6 20:13
 * @Version 1.0
 **/
public class TwoSum {
    public static int[] twoSum3(int[] nums,int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target-nums[i];
            if(hashMap.containsKey(j)){
               return new int[]{i,hashMap.get(j)};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }
    /**
     * 时间复杂度 T =O(n)
     * 空间复杂度 T =O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int j = target-nums[i];
            if(hashMap.containsKey(j) && hashMap.get(j) != i){
                return new int[]{i,hashMap.get(j)};
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums.length ; j++) {
                if(i != j && nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    //题后感:可以多用hashMap等查找效率高的数据结构来代替遍历

}
