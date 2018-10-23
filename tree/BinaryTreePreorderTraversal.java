package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 问题描述：给定一个二叉树，返回它的 前序 遍历。
 *  示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗
 * @ClassName BinaryTreePreorderTraversal
 * @Author htx
 * @Date 2018/10/9 17:03
 * @Version 1.0
 **/
public class BinaryTreePreorderTraversal {
//    递归实现
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        doPreorderTraversal(root,arrayList);
        return arrayList;
    }

    public void doPreorderTraversal(TreeNode root,ArrayList arrayList) {
        if(root != null){
            arrayList.add(root.val);
            doPreorderTraversal(root.left,arrayList);
            doPreorderTraversal(root.right,arrayList);
        }

    }
    
//    非递归实现
    public static List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> preorderTraversal = new ArrayList<>();
        if(root == null){
            return preorderTraversal;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pointer = root;
        while(pointer != null || !stack.isEmpty()){
           while(pointer != null){
               preorderTraversal.add(pointer.val);
               stack.push(pointer);
               pointer = pointer.left;
           }
           if(!stack.isEmpty()){
               TreeNode pop = stack.pop();
               pointer = pop.right;
           }
        }
        return preorderTraversal;
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1,null,new TreeNode(2,treeNode3,null));
        preorderTraversal2(treeNode1);
    }
}
