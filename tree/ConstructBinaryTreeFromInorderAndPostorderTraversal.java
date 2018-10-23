package algorithm.leetcode.tree;

/**
 * 从中序与后序遍历序列构造二叉树
 * 问题描述：
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @ClassName ConstructBinaryTreeFromInorderAndPostorderTraversal
 * @Author htx
 * @Date 2018/10/11 10:28
 * @Version 1.0
 **/
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0){
            return null;
        }
        TreeNode root = build(postorder, postorder.length - 1,0,inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode build( int[] postorder, int postorderStart, int postorderEnd,int[] inorder, int inorderStart, int inorderEnd) {
        TreeNode root = new TreeNode(postorder[postorderStart]);
//        边界条件
        if(postorderStart == postorderEnd){
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

        int leftChildLength = rootIndex - inorderStart;
        int rightChildLength = inorderEnd - rootIndex;
        if(leftChildLength > 0){
           root.left = build(postorder,postorderStart-rightChildLength-1,postorderEnd,inorder,inorderStart,rootIndex-1);
        }
        if(rightChildLength > 0){
            root.right = build(postorder,postorderStart-1,postorderEnd,inorder,rootIndex+1,inorderEnd);
        }

        return root;
    }
}
