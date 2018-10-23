package algorithm.leetcode.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 问题描述：
 * 给定一个二叉树，返回它的中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @ClassName BinaryTreeInorderTraversal
 * @Author htx
 * @Date 2018/10/9 17:00
 * @Version 1.0
 **/
public class BinaryTreeInorderTraversal {
//    递归实现
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        doInorderTraversal(root,arrayList);
        return arrayList;
    }

    private void doInorderTraversal(TreeNode root, ArrayList<Integer> arrayList) {
        if(root != null){
            doInorderTraversal(root.left,arrayList);
            arrayList.add(root.val);
            doInorderTraversal(root.right,arrayList);
        }
    }

//    非递归实现,使用栈
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> inorderTraversal = new ArrayList<>();
        if(root == null){
            return inorderTraversal;
        }
        Stack<TreeNode> stack = new Stack<>();
//        指针
        TreeNode pointer = root;
        while(!stack.isEmpty() || pointer != null){
            while(pointer != null){
                stack.push(pointer);
                pointer = pointer.left;
                continue;
            }

            if(!stack.isEmpty()){
                TreeNode pop = stack.pop();
                inorderTraversal.add(pop.val);
                pointer = pop.right;
            }

        }
        return inorderTraversal;


    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1,null,new TreeNode(2,treeNode3,null));
        inorderTraversal2(treeNode1);
    }


}
