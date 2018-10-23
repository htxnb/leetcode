package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 问题描述：
 * 给定一个二叉树，返回它的 后序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @ClassName BinaryTreePostorderTraversal
 * @Author htx
 * @Date 2018/10/9 17:02
 * @Version 1.0
 **/
public class BinaryTreePostorderTraversal {
//    递归实现
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        doPostorderTraversal(root,arrayList);
        return arrayList;
    }

    private void doPostorderTraversal(TreeNode root, ArrayList<Integer> arrayList) {
        if(root != null){
            doPostorderTraversal(root.left,arrayList);
            doPostorderTraversal(root.right,arrayList);
            arrayList.add(root.val);
        }
    }

//    非递归实现，双栈法
    public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> postorderTraversal = new ArrayList<>();
        if(root != null) {
            Stack<TreeNode> pushstack = new Stack<>();
            pushstack.push(root);
            Stack<TreeNode> popstack = new Stack<>();
            while (!pushstack.isEmpty()) {
                TreeNode pop = pushstack.pop();
                popstack.push(pop);
                if (pop.left != null) {
                    pushstack.push(pop.left);
                }
                if (pop.right != null) {
                    pushstack.push(pop.right);
                }
            }

            while (!popstack.isEmpty()) {
                postorderTraversal.add(popstack.pop().val);
            }
        }
        return postorderTraversal;
    }
}
