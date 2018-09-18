package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * @ClassName YangHuiTriangleAdvanced
 * @Author htx
 * @Date 2018/9/10 10:56
 * @Version 1.0
 **/
public class YangHuiTriangleAdvanced {
    /**
     * 根据杨辉三角|的方法进行改造，prev_list指针指向上一行，current_list指针指向下一行
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> current_list = new ArrayList<>();
        List<Integer> prev_list = new ArrayList<>();
        prev_list.add(1);
        prev_list.add(1);
        //行数
        for (int i = 0; i <= rowIndex; i++) {
            current_list.add(1);
            //判断是否有上一行
            if(i-1>0){
                //除1以外需要变化的部分
                for (int j = 1; j < i && j-1>=0; j++) {
                    current_list.add(prev_list.get(j)+prev_list.get(j-1));
                }
            }
            if(i>0){
                current_list.add(1);
            }
            prev_list = current_list;
            current_list = new ArrayList<>();
        }
        return prev_list;
    }
}
