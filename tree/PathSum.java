package algorithm.leetcode.tree;

/**
 * 问题描述：
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * @ClassName PathSum
 * @Author htx
 * @Date 2018/10/22 16:11
 * @Version 1.0
 **/
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return sumPath(root,sum,0);
    }

    private boolean sumPath(TreeNode root, int sum, int currentSum) {
        if(root == null){
            return false;
        }
        currentSum += root.val;
        boolean left = sumPath(root.left,sum,currentSum);
        boolean right = sumPath(root.right,sum,currentSum);
        if( root.left == null && root.right == null && currentSum == sum){
            return true;
        }
        return left | right;
    }
}
