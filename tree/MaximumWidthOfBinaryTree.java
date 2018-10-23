package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 问题描述：
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * 示例 1:
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 * 输入:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 * @ClassName MaximumWidthOfBinaryTree
 * @Author htx
 * @Date 2018/10/21 19:53
 * @Version 1.0
 **/
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> depths = new ArrayList<>();
        queue.add(root);
        depths.add(0);
        int max = 0,preNodes = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            int start = preNodes+1,end = start-1;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                end++;
                if(poll.left != null){
                    queue.add(poll.left);
                    depths.add(2*depths.get(end) +1);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                    depths.add(2*depths.get(end) +2);
                }
                preNodes++;
            }
            if(end < depths.size()){
                int width = depths.get(end)-depths.get(start)+1;
                max = Integer.max(max,width);
            }
        }
        return max;
    }



    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7,null,null);
        TreeNode treeNode6 = new TreeNode(6,null,null);
        TreeNode treeNode5 = new TreeNode(5,null,treeNode7);
        TreeNode treeNode4 = new TreeNode(4,treeNode6,null);
        TreeNode treeNode3 = new TreeNode(3,null,treeNode5);
        TreeNode treeNode2 = new TreeNode(2,treeNode4,null);
        TreeNode treeNode = new TreeNode(1,treeNode2,treeNode3);
        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();
        System.out.println(maximumWidthOfBinaryTree.widthOfBinaryTree(treeNode));
    }

}
