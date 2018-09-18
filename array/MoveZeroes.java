package leetcode.array;

/**
 * 问题描述：
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * (1)必须在原数组上操作，不能拷贝额外的数组。
 * (2)尽量减少操作次数。
 * @ClassName MoveZeroes
 * @Author htx
 * @Date 2018/9/10 10:54
 * @Version 1.0
 **/
public class MoveZeroes {
    /**
     * 根据荷兰国旗问题的算法进行改造，借助两个指针从数组首位开始，将非零数放到前面(保证非零数的相对顺序)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int current = 0,nonZeros = -1;
        while(current < nums.length){
            if(nums[current] != 0){
                swap(nums,current,++nonZeros);
            }
            current++;
        }
    }
    public void swap(int[] nums,int i,int j){
        //需要对下标进行限制，否则两个下标相同的元素进行交换，会将这个元素置为0
        if(i == j){
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
