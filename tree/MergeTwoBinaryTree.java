package algorithm.leetcode.tree;

/**
 *问题描述：
 *   给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *   你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *   示例 1:
 *   输入:
 *   	Tree 1                     Tree 2
 *             1                         2
 *            / \                       / \
 *           3   2                     1   3
 *          /                           \   \
 *         5                             4   7
 *   输出:
 *   合并后的树:
 *   	     3
 *   	    / \
 *   	   4   5
 *   	  / \   \
 *   	 5   4   7
 *   注意: 合并必须从两个树的根节点开始。
 *   @ClassName MergeTwoBinaryTree
 *   @Author htx
 *   @Date 2018/9/21 9:54
 *   @Version 1.0
 */
public class MergeTwoBinaryTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null){
            return t1 == null ? t2 : t1;
        }else{
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left,t2.left);
            t1.right = mergeTrees(t1.right,t2.right);
            return t1;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = new TreeNode(3,new TreeNode(5),null);
        t1.right = new TreeNode(2);

        t2.left = new TreeNode(1,null,new TreeNode(4));
        t2.right = new TreeNode(3,null,new TreeNode(7));

        MergeTwoBinaryTree mergeTwoBinaryTree = new MergeTwoBinaryTree();
        System.out.println(mergeTwoBinaryTree.mergeTrees(t1,t2));
    }
}


