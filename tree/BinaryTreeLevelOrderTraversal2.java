package algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 问题描述：
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * @ClassName BinaryTreeLevelOrderTraversal2
 * @Author htx
 * @Date 2018/10/10 17:14
 * @Version 1.0
 **/
public class BinaryTreeLevelOrderTraversal2 {
    /**
     * 这道其实很像
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> levelOrderTraversal = new LinkedList<>();
        if(root == null){
            return levelOrderTraversal;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int eachLevelsize = queue.size();
            List<Integer> integers = new LinkedList<>();
            for (int i = 0; i < eachLevelsize; i++) {
                TreeNode poll = queue.poll();
                integers.add(poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }

                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            levelOrderTraversal.addFirst(integers);
        }
        return levelOrderTraversal;
    }

}
