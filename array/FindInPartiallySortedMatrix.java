package leetcode.array;


/**
 * 问题描述：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排列，
 * 每一列都按照从上到下的顺序排列。完成一个函数，输入一个二维数组和一个整数，判断该数组中是否有这个数
 * @ClassName ArraySearch
 * @Author htx
 * @Date 2018/9/10 10:17
 * @Version 1.0
 **/
public class FindInPartiallySortedMatrix {
    public static int[] find(int[][] array,int target){
        int current_row = 0;
        int current_col = array[0].length-1;
        while(current_col >= 0 && current_row < array.length){
            if(array[current_row][current_col] > target){
                current_col--;
            }else if(array[current_row][current_col] < target){
                current_row++;
            }else{
                return new int[]{current_row,current_col};
            }
        }
        return null;
    }


}
