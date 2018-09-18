package leetcode.array;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 问题描述：
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * 示例 1：
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 * 输入：[1,3,2]
 * 输出：false
 * 示例 4：
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例 5：
 * 输入：[1,1,1]
 * 输出：true
 * 提示：
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 *
 * @ClassName MonotonicArray
 * @Author htx
 * @Date 2018/9/10 11:01
 * @Version 1.0
 **/
public class MonotonicArray {
    public static  boolean isMonotonic(int[] A) {
       if(A.length == 1){
           return true;
       }
       int current = 0;
       //1代表增，-1代表减
       int flag = 0;
       while(current < A.length-1){
           if(A[current] > A[current+1]){
               flag = -1;
               break;
           }else if(A[current] < A[current+1]){
               flag = 1;
               break;
           }else{
               current++;
           }
       }
        for (int i = 0; i < A.length-1; i++) {
            if((A[i+1] - A[i])*flag < 0){
                return false;
            }
        }
       return true;
    }

    public static void main(String[] args) {
        int[] ints = {1,1,0};
        System.out.println(isMonotonic(ints));
    }
}
