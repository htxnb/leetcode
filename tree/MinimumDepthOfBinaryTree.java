package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 * @ClassName MinimumDepthOfBinaryTree
 * @Author htx
 * @Date 2018/10/21 21:48
 * @Version 1.0
 **/
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        ArrayList<Integer> depths = new ArrayList<>();
        minDepthRecursion(root,1,depths);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < depths.size(); i++) {
            min = Math.min(min,depths.get(i));
        }
        return min;
    }

    private void minDepthRecursion(TreeNode root, int depth,List<Integer> depths) {
        if(root == null){
            return;
        }
        minDepthRecursion(root.left,depth+1,depths);
        minDepthRecursion(root.right,depth+1,depths);
        if(root.left == null && root.right == null){
            depths.add(depth);
        }
    }
}
