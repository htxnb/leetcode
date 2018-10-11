package leetcode.tree;

/**
 * 问题描述：
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * Example 1:
 * 输入: [3,2,1,6,0,5]
 * 输入: 返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * 注意:
 * 给定的数组的大小在 [1, 1000] 之间。
 * @ClassName MaximumBinaryTree
 * @Author htx
 * @Date 2018/10/8 19:47
 * @Version 1.0
 **/
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length < 2){
            return nums.length == 0 ? null : new TreeNode(nums[0]);
        }else{
            return constructMaximumBinaryTree(nums, 0, nums.length - 1);
        }
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if(left <= right){
            int maxIndex = left;
//            定位最大值的索引
            for (int i = left+1; i <= right; i++) {
                if(nums[i] > nums[maxIndex]){
                    maxIndex = i;
                }
            }
//            递归部分
            TreeNode treeNode = new TreeNode(nums[maxIndex]);
            treeNode.left = constructMaximumBinaryTree(nums,left,maxIndex-1);
            treeNode.right = constructMaximumBinaryTree(nums,maxIndex+1,right);
            return treeNode;
        }else{
            return null;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        TreeNode treeNode = maximumBinaryTree.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}
