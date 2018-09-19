package leetcode.array;

import java.util.Arrays;

/**
 * 问题描述：
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * @ClassName PlusOne
 * @Author htx
 * @Date 2018/9/15 21:49
 * @Version 1.0
 **/
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int single = digits.length-1;
        int[] temp = null;
        while(single >= 0){
            if(digits[single] + 1 == 10){
                digits[single] = 0;
                single--;
                if(single < 0){
                    temp = new int[digits.length+1];
                    System.arraycopy(digits,0,temp,1,digits.length);
                    digits = temp;
                    single = 0;
                }
                continue;
            }else{
                digits[single]++;
                break;
            }

        }
        return digits;
    }

    public static void main(String[] args) {
        int[] ints = {1,8,};
        System.out.println(Arrays.toString(plusOne(ints)));
    }
}
