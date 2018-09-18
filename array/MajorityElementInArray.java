package leetcode.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 问题描述：
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @ClassName MajorityElementInnumsay
 * @Author htx
 * @Date 2018/9/10 10:54
 * @Version 1.0
 **/
public class MajorityElementInArray {
    /**
     * 利用hashmap常数级的查找效率
     * @param nums
     * @return
     */
    public int findMajorityElement(int[] nums){

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],1);
            }else{
                Integer times = hashMap.get(nums[i]);
                hashMap.replace(nums[i],times+1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue() > nums.length/2){
                return next.getKey();
            }
        }

        return 0;

    }

    /**
     * 统计基准元素的次数，遇到不等的次数减一(相当于抵消掉一个)，遇到相等的次数加一，
     * 最后剩下的一定是众数
     * @param nums
     * @return
     */
    public int findMajorityElement1(int[] nums){
        int count = 0;
        int result = 0;
        for (int i = 0; i < nums.length ;i++) {
            if(count == 0){
                result = nums[i];
                count++;
            }else{
                if(result == nums[i]){
                    count++;
                }else{
                    count--;
                }
            }

        }

        return result;
    }


}
