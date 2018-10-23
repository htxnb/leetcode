package algorithm.leetcode.tree;

/**
 * 问题描述：
 * 给出一个完全二叉树，求出该树的节点个数。
 * 说明：
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * 示例:
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 * @ClassName CountCompleteTreeNodes
 * @Author htx
 * @Date 2018/10/21 19:53
 * @Version 1.0
 **/
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getChildTreeLevels(root.left);
        int right = getChildTreeLevels(root.right);
        if(left == right){
            return (1 << left) + countNodes(root.right);
        }else{
            return (1 << right) + countNodes(root.left);
        }
    }

    private int countNodesRecursion(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countNodesRecursion(root.left);
        int right = countNodesRecursion(root.right);
        return left+right+1;
    }

    private int getChildTreeLevels(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode pointer = root;
        int levels = 0;
        while(pointer != null){
            levels++;
            pointer = pointer.left;
        }
        return levels;
    }
}
