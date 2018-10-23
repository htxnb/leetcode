package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 问题描述：
 * 您需要在二叉树的每一行中找到最大的值。
 * 示例：
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 * 输出: [1, 3, 9]
 * @ClassName FindLargestValueInEachTreeRow
 * @Author htx
 * @Date 2018/10/18 15:16
 * @Version 1.0
 **/
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> largestValues = new ArrayList<>();
        if(root == null){
            return largestValues;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int maxEachLevel = Integer.MIN_VALUE;
//            遍历每一层
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                maxEachLevel = Math.max(maxEachLevel,poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
//            遍历每一层结束后，添加每一层最大值
            largestValues.add(maxEachLevel);

        }
        return largestValues;
    }
}
