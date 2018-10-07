package leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * 问题描述：
 *  给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作
 * @ClassName CountingBits
 * @Author htx
 * @Date 2018/9/25 14:54
 * @Version 1.0
 **/
public class CountingBits {
    /**
     * a[n] = a[n/2]     　　　　　　n为偶数
     * a[n] = a[n-1] +1　　　　　　 n为奇数
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] results = new int[num + 1];
        results[0] = 0;
        for (int i = 1; i <= num; i++) {
            if(isFactorialOfTwo(i)){
                results[i] = 1;
            }else{
                if(i % 2 != 0){
                    results[i] = results[i-1]+1;
                }else{
                    results[i] = results[i/2];
                }
            }


        }
        return results;
    }

    public static boolean isFactorialOfTwo(int m){
        return m > 0 ? (m & (m-1)) == 0: false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(16)));
    }
}
