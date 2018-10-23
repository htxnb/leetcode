package algorithm.leetcode.tree;

/**
 * 从前序与中序遍历序列构造二叉树
 * 问题描述：
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @ClassName ConstructBinaryTreeFromPreorderandInorderTraversal
 * @Author htx
 * @Date 2018/10/11 10:26
 * @Version 1.0
 **/
public class ConstructBinaryTreeFromPreorderandInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0){
            return null;
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inorderStart, int inorderEnd) {
        TreeNode root = new TreeNode(preorder[preStart]);
//        当前序遍历只有根节点时，返回
        if(preStart == preEnd){
            return root;
        }

//        确定根节点的索引
        int rootIndex = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if(inorder[i] == root.val){
                rootIndex = i;
                break;
            }
        }
//        左子树的长度
        int leftChildTreeLength = rootIndex - inorderStart;

        if(leftChildTreeLength > 0){
            root.left = build(preorder,preStart+1,preEnd,inorder,inorderStart,rootIndex-1);
        }

        if(inorderEnd-rootIndex > 0){
            root.right = build(preorder,preStart + leftChildTreeLength+1,preEnd,inorder,rootIndex+1,inorderEnd);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        buildTree(pre,in);
    }

}
