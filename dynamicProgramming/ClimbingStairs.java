package leetcode.dynamicProgramming;

import java.util.HashMap;

/**
 * 问题描述：
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @ClassName ClimbingStairs
 * @Author htx
 * @Date 2018/9/23 19:42
 * @Version 1.0
 **/
public class ClimbingStairs {

    public static HashMap<Integer,Integer> hashMap= new HashMap<>();

    /**
     *动态规划---自顶向下的备忘录算法
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        Integer values = 0;
//        充当缓存,暂存子问题中的公共部分
        if(hashMap.containsKey(n)){
            return hashMap.get(n);
        }else{
            values = climbStairs(n - 1) + climbStairs(n - 2);
            hashMap.put(n,values);
            return values;
        }
    }

    /**
     *动态规划---自下向上
     * @param n
     * @return
     */
    public static int climbStairs2(int n){
        if(n < 3){
            return n == 1 ? 1 : 2 ;
        }
        int[] ints = new int[n+1];
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs2(4));
    }
}
