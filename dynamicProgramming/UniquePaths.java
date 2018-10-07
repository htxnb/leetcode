package leetcode.dynamicProgramming;

/**
 * 问题描述：
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 说明：m 和 n 的值均不超过 100。
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 * @ClassName UniquePaths
 * @Author htx
 * @Date 2018/10/6 10:41
 * @Version 1.0
 **/
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        int currentRow = 0,currentCol = 0;
        while(currentRow < m && currentCol < n){
            if(currentCol == 0 && currentRow == 0){
                paths[currentRow][currentCol] = 1;
            }else{
                countPath(paths,currentRow,currentCol,m,n);
            }

            if(currentRow + 1 < m){
                currentRow++;
            }else{
                currentCol++;
            }
        }
        return paths[m-1][n-1];
    }

    private static void countPath(int[][] paths, int currentRow, int currentCol, int m, int n) {
        while(currentRow >= 0 && currentCol < n){
            if(currentRow -1 >= 0){
                paths[currentRow][currentCol] += paths[currentRow-1][currentCol];
            }
            if(currentCol - 1 >= 0){
                paths[currentRow][currentCol] += paths[currentRow][currentCol-1];
            }
            currentRow--;
            currentCol++;
        }
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
}
