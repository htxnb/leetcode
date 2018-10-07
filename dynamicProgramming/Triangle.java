package leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 *
 * {
 *      {2},
 *     {3,4},
 *    {6,5,7},
 *   {4,1,8,3}
 * }
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分
 * @ClassName Triangle
 * @Author htx
 * @Date 2018/9/23 22:56
 * @Version 1.0
 **/
public class Triangle {
    /**
     * 动态规划，自顶下上思考问题，自下往上求解问题
     * 状态：到第i行第j列的最短路径，记作dp[i][j]
     * 状态迁移方程：dp[i][j] = min(dp[i-1][j],dp[i-1][j-1])
     * 求解过程：从第0行第0列开始计算好到该位置的最短路径，最后求出最后一行中路径中的最小值
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> lengths = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            lengths.add(new ArrayList<Integer>(triangle.get(i).size()));
        }
        lengths.get(0).add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int currentLength = min(lengths, i, j);
                lengths.get(i).add(currentLength+triangle.get(i).get(j));
            }
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i <lengths.get(lengths.size()-1).size() ; i++) {
            minValue = Math.min(minValue,lengths.get(lengths.size()-1).get(i));
        }
        return minValue;
    }

    /**
     *
     * @param lengths
     * @param i
     * @param j
     * @return
     */
    private static int min(List<List<Integer>> lengths, int i, int j) {
        Integer min = Integer.MAX_VALUE;
        if(j < lengths.get(i-1).size()){
            min = Math.min(min,lengths.get(i-1).get(j));
        }

        if(j - 1 >= 0){
            min = Math.min(min, lengths.get(i-1).get(j-1));
        }


        return min;
    }


}
