package algorithm.leetcode.tree;

import java.util.Stack;

/**
 * 问题描述：
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * 示例 1:
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 * @ClassName ConstructStringFromBinaryTree
 * @Author htx
 * @Date 2018/10/17 15:16
 * @Version 1.0
 **/
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        return constructString(root);
    }

    private String constructString(TreeNode root) {
        if(root == null){
            return "";
        }

//        根节点
        String treeStr = "" + root.val;
//        左子树
        if(root.left != null){
            treeStr += "(" + constructString(root.left) + ")";
        }else if(root.right != null){
            treeStr += "()";
        }

        if(root.right != null){
            treeStr += "(" + constructString(root.right) + ")";
        }
//        右子树
        return treeStr;
    }
}
