package leetcode.tree;


import java.util.ArrayList;
import java.util.List;

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

//    非递归实现



}
