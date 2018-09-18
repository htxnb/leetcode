package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 问题描述：
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 示例 1:
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数
 * @ClassName DegreeOfArray
 * @Author htx
 * @Date 2018/9/13 21:49
 * @Version 1.0
 **/
public class DegreeOfArray {
    /**
     * 运用hashMap解决问题
     * @param nums
     * @return
     */
    public static int findShortestSubArray(int[] nums) {
       /*设一个HashMap<Integer, int[]> map，
        key 就是 num，value 就是int[3]: int[0] 记录 firstIndex; int[1] 记录 lastIndex; int[2] 记录次数。*/
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        Integer max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
//                更新出现的下标
                hashMap.get(nums[i])[1] = i;
//                更新出现的次数
                hashMap.get(nums[i])[2]++;
            }else{
                int[] ints = new int[3];
                ints[0] = i;
                ints[1] = i;
                ints[2] = 1;
                hashMap.put(nums[i],ints);
            }
//            更新出现次数最多的值
            max = Math.max(hashMap.get(nums[i])[2],max);
        }

        int  subArrayLength = Integer.MAX_VALUE;
        for(Integer num : hashMap.keySet()){
            if(max == hashMap.get(num)[2]){
                subArrayLength = Math.min(hashMap.get(num)[1]-hashMap.get(num)[0]+1,subArrayLength);
            }
        }

        return subArrayLength;
    }


}
