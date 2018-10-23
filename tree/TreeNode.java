package algorithm.leetcode.tree;

/**
 * @ClassName TreeNode
 * @Author htx
 * @Date 2018/9/21 9:56
 * @Version 1.0
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){

    }
    public TreeNode(int x) { val = x; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
