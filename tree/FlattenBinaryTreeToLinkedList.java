package leetcode.tree;

/**
 * 问题描述：
 * 给定一个二叉树，原地将它展开为链表。
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * @ClassName FlattenBinaryTreeToLinkedList
 * @Author htx
 * @Date 2018/10/10 17:16
 * @Version 1.0
 **/

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        preOrderTraversal(root,queue);
        TreeNode pointer = queue.poll();
        while(!queue.isEmpty()){
            pointer.left = null;
            pointer.right = queue.poll();
            pointer = pointer.right;
        }

    }

    private void preOrderTraversal(TreeNode root, LinkedList<TreeNode> queue) {
        if(root != null){
            queue.add(root);
            preOrderTraversal(root.left,queue);
            preOrderTraversal(root.right,queue);
        }
    }


}
