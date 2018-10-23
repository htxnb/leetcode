package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 问题描述：给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @ClassName BinaryTreeLevelOrderTraversal
 * @Author htx
 * @Date 2018/10/9 17:04
 * @Version 1.0
 **/
public class BinaryTreeLevelOrderTraversal {
//    二叉树的层次遍历是BFS(宽度优先搜素)思想，用队列来解决
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> level = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    level.add(poll.val);
                    if(poll.left != null){
                        queue.add(poll.left);
                    }
                    if(poll.right != null){
                        queue.add(poll.right);
                    }
                }
                arrayLists.add(level);
            }
        }
        return arrayLists;

    }



}
