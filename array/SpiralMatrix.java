package leetcode.array;

/**
 * 问题描述
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @ClassName SpiralMatrix
 * @Author htx
 * @Date 2018/9/15 9:18
 * @Version 1.0
 **/
public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0,right = n-1,top = 0,bottom = n-1,number = 0;
        while(left < right && top < bottom){
//            添加向右的行
           for (int i = left; i <= right; i++) {
               matrix[top][i] = ++number;
           }
           top++;
//           添加向下的行
           for (int i = top; i <= bottom; i++) {
               matrix[i][right] = ++number;
           }
           right--;
//           添加向左的行
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = ++number;
            }
            bottom--;
//            添加向上的行
            for (int i = bottom; i >= top ; i--) {
                matrix[i][left] = ++number;
            }
            left++;

        }
//        如果n是奇数，则打印中间的点
        if(n % 2 != 0){
            matrix[n/2][n/2] = ++number;
        }
        return matrix;
    }

//    题后感:螺旋问题抓住left,right,top,bottom四个指针的变化
}
