package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：
 * 计算给定二叉树的所有左叶子之和。
 * 示例：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * @ClassName SumOfLeftLeaves
 * @Author htx
 * @Date 2018/10/19 14:01
 * @Version 1.0
 **/
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        ArrayList<Integer> leftNodes = new ArrayList<>();
        sumOfLeftLeavesRecursion(root,leftNodes);
        int sum = 0;
        for (int i = 0; i < leftNodes.size(); i++) {
            sum += leftNodes.get(i);
        }
        return sum;
    }

    private void sumOfLeftLeavesRecursion(TreeNode root, List<Integer> leftNodes) {
        if(root == null){
            return;
        }
        if(root.left != null){
            leftNodes.add(root.left.val);
        }
        sumOfLeftLeavesRecursion(root.left,leftNodes);
        sumOfLeftLeavesRecursion(root.right,leftNodes);
    }

    public static void main(String[] args) {

    }
}
