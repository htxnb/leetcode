package leetcode.array;

/**
 * 问题描述:
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * 输出: True
 * 解释:
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是True。
 * 示例 2:
 * 输入:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * 输出: False
 * 解释:
 * 对角线"[1, 2]"上的元素不同。
 * 说明:
 * (1)matrix 是一个包含整数的二维数组。
 * (2)matrix 的行数和列数均在 [1, 20]范围内。
 * (3)matrix[i][j] 包含的整数在 [0, 99]范围内。
 * @ClassName ToeplitzMatrix
 * @Author htx
 * @Date 2018/9/10 10:52
 * @Version 1.0
 **/
public class ToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int upperRow = matrix.length, upperCol = 0, lowerRow = matrix.length-1, lowerCol = -1;
        while(upperCol < matrix[0].length-1 || upperRow > 0){
//            限制上面指针的移动范围
            if(upperRow > 0){
                upperRow--;
            }else{
                upperCol++;
            }

//            限制下面指针的移动范围
            if(lowerCol < matrix[0].length-1){
                lowerCol++;
            }else{
                lowerRow--;
            }

            if(!compareInSameRow(matrix,upperRow,upperCol,lowerRow,lowerCol)){
                return false;
            }

        }
        return true;
    }

//    比较一行上的元素是否相等
    public static boolean compareInSameRow(int[][] matrix,int a_row,int a_col,int b_row,int b_col){
        if(a_row == b_row && a_col == b_col){
            return true;
        }
        int compared = matrix[a_row][a_col];
        int row = a_row,col = a_col;
        while(row < b_row && col < b_col){
            if(compared != matrix[++row][++col]){
                return false;
            }
        }

        return true;
    }

    public boolean isToeplitzMatrix2(int[][] matrix) {
        int pos = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        while(pos < row-1){
            int[] temp = matrix[++pos];
            for (int j = 0; j < matrix[0].length-1; j++) {
                if(temp[j+1] != matrix[pos-1][j]){
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[][] ints = {{11,74,0,93},{40,11,74,7}};
        System.out.println(isToeplitzMatrix(ints));
    }
}
