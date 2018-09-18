package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：
 *给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * @ClassName YangHuiTriangle
        * @Author htx
        * @Date 2018/9/6 19:59
        * @Version 1.0
        **/
public class YangHuiTriangle {
    /**
     * 解题思路：
     * 其实就是从第0行一直遍历到第n-1行，
     * 第i行的首尾元素为1，第i行的第k个元素等于上一行第k个元素和第k-1个元素之和
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            lists.add(new ArrayList<>());
        }
        //行数
        for (int i = 0; i < numRows; i++) {
            List<Integer> current_list = lists.get(i);
            current_list.add(1);
            //判断是否有上一行
            if(i-1>0){
                List<Integer> prev_list = lists.get(i - 1);
                //除1以外需要变化的部分
                for (int j = 1; j < i && j-1>=0; j++) {
                    current_list.add(prev_list.get(j)+prev_list.get(j-1));
                }
            }

            if(i>0){
                current_list.add(1);
            }

        }
        return lists;
    }


}
