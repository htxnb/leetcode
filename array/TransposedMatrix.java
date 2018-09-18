package leetcode.array;

/**
 * 问题描述：给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * 示例 1：
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * 提示：
 * 1.  1 <= A.length <= 1000
 * 2.  1 <= A[0].length <= 1000
 *
 * @ClassName TransposedMatrix
 * @Author htx
 * @Date 2018/9/6 18:27
 * @Version 1.0
 **/
public class TransposedMatrix {

    /**
     * 转置矩阵的特征：尺寸为 R x C 的矩阵 A 转置后会得到尺寸为 C x R 的矩阵 ans，对此有 ans[c][r] = A[r][c]
     * @param matrix
     * @return
     */
    public static int[][] transposedMatrix(int[][] matrix){
        int rows_old = matrix.length;
        int cols_old = matrix[0].length;
        int[][] temp = new int[cols_old][rows_old];
        for (int i = 0; i < rows_old; i++) {
            for (int j = 0; j < cols_old; j++) {
                temp[j][i] = matrix[i][j];
            }
        }
        return temp;
    }


}
