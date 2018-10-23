package algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题描述：
 *给定一个二叉树，在树的最后一行找到最左边的值。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 * 示例 2:
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 * 输出:
 * 7
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 * @ClassName FindBottomLeftTreeValue
 * @Author htx
 * @Date 2018/10/17 19:53
 * @Version 1.0
 **/
public class FindBottomLeftTreeValue {
    public  int findBottomLeftValue(TreeNode root) {
        return findBottomLeft(root,0).bottomNode.val;
    }
    public Path findBottomLeft(TreeNode root,int currentLevel) {

        if(root == null){
            return new Path(-1,null);
        }
        if(root.left == null && root.right == null){
            return new Path(currentLevel,root);
        }
        Path bottomLeft = findBottomLeft(root.left,currentLevel+1);
        Path bottomRight = findBottomLeft(root.right,currentLevel+1);
        return bottomLeft.level >= bottomRight.level ?bottomLeft:bottomRight;
    }

    class Path{
        public int level = 0;
        public TreeNode bottomNode = null;

        public Path(int level, TreeNode bottomNode) {
            this.level = level;
            this.bottomNode = bottomNode;
        }
    }
    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode0 = new TreeNode(0, null, null);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode3);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode0, treeNode2);
        TreeNode treeNode5 = new TreeNode(5, treeNode4, treeNode6);
        TreeNode root = new TreeNode(3, treeNode1, treeNode5);
        FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
        System.out.println(findBottomLeftTreeValue.findBottomLeftValue(root));
    }
}
