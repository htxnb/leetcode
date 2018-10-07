package leetcode.dynamicProgramming;

/**
 * 问题描述：
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，以下数列为等差数列:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 * 1, 1, 2, 5, 7
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 * 示例:
 * A = [1, 2, 3, 4]
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]
 * @ClassName ArithmeticSlices
 * @Author htx
 * @Date 2018/9/25 16:12
 * @Version 1.0
 **/
public class ArithmeticSlices {
    /**
     * 对于一个长度为n的数组A，在长度为n-1的子数组的等差子数组基础上再加上以A[n-1]结尾的等差数列个数
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3){
            return 0;
        }
        int[] numbers = new int[A.length];
        numbers[0] = 0;
        numbers[1] = 0;
        for (int i = 2; i < numbers.length; i++) {
            int decreaseLength = 2;
            int decrease = A[i] - A[i-1];
            for (int j = i-1; j > 0 ; j--) {
                if(A[j]-A[j-1] == decrease){
                    decreaseLength++;
                }else{
                    break;
                }

                if(decreaseLength >= 3){
                    numbers[i]++;
                }

            }
            numbers[i] += numbers[i-1];
        }
        return numbers[A.length-1];
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,8,9,10};
        System.out.println(numberOfArithmeticSlices(ints));
    }

}
