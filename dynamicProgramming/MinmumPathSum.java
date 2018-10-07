package leetcode.dynamicProgramming;

/**
 * 问题描述：
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * @ClassName MinmumPathSum
 * @Author htx
 * @Date 2018/9/25 15:52
 * @Version 1.0
 **/
public class MinmumPathSum {
    /**
     * 状态：第i行第j列到左上角的最小路径和，记作dp[i][j]
     * 状态迁移方程：dp[i][j] = min(dp[i][j-1],dp[i-1][j]) + values[i][j]
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[][] path = new int[grid.length][grid[0].length];
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
               int minPath = minPath(path,i,j);
               path[i][j] = minPath + grid[i][j];
            }
        }
        return path[grid.length-1][grid[0].length-1];
    }

    private int minPath(int[][] path, int i, int j) {
        if(i == 0 && j == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if(j-1 >= 0){
            min = Math.min(path[i][j-1],min);
        }
        if(i-1 >= 0){
            min = Math.min(min,path[i-1][j]);
        }
        return min;
    }
}
