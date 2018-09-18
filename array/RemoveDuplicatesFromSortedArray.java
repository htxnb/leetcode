package leetcode.array;


import java.util.Arrays;

/**
 * 问题描述：
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * @ClassName RemoveDuplicatesFromSortedArray
 * @Author htx
 * @Date 2018/9/13 21:43
 * @Version 1.0
 **/
public class RemoveDuplicatesFromSortedArray {
    /**
     * 参照荷兰国旗问题，left指针代表已去重区域，current指针遍历整个数组，将元素和已去重区域进行比较，若有重复的则继续
     * current指针往后走，若没有重复的，则将当前元素替换到已去重区域
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int left = 0,current = 1,flag = 0;
        while(current < nums.length){
            for (int i = 0; i <= left; i++) {
                if(nums[current] == nums[i]){
                    current++;
                    break;
                }
                flag++;
            }
            if(flag > left){
                swap(nums,current++,++left);
             }
             flag = 0;
        }
        return left+1;
    }
    public static int removeDuplicates1(int[] nums) {
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[left]){
                swap(nums,++left,i);
            }
        }
        return left+1;
    }

    public static boolean binarySearch(int[] arr,int left,int right,int target){
        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            if(arr[mid] < target){
                left = mid+1;
            }else if(arr[mid] > target){
                right = mid-1;
            }else{
                return true;
            }
        }
        return false;

    }
    public static void swap(int[] arr,int i,int j){
        if(i == j){
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        removeDuplicates1(arr);
        System.out.println(12+30+31+30+31+31+13);
        }
}
