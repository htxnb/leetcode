package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例 1:
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * @ClassName SumRootToLeafNumbers
 * @Author htx
 * @Date 2018/10/18 15:28
 * @Version 1.0
 **/
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        sumNumbersRecursion(root,"",arrayList);
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i);
        }
        return sum;
    }

    private void sumNumbersRecursion(TreeNode root, String sum,List<Integer> arrayList) {
        if(root == null){
            return;
        }
        sum += root.val;
        if(root.left == null && root.right == null){
            arrayList.add(Integer.parseInt(sum));
        }
        sumNumbersRecursion(root.left,sum,arrayList);
        sumNumbersRecursion(root.right,sum,arrayList);
    }
}
