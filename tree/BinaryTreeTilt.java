package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：
 * 给定一个二叉树，计算整个树的坡度。
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 整个树的坡度就是其所有节点的坡度之和。
 * 示例:
 * 输入:
 *          1
 *        /   \
 *       2     3
 * 输出: 1
 * 解释:
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 * 注意:
 *
 * 任何子树的结点的和不会超过32位整数的范围。
 * 坡度的值不会超过32位整数的范围。
 * @ClassName BinaryTreeTilt
 * @Author htx
 * @Date 2018/10/19 15:43
 * @Version 1.0
 **/
public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        ArrayList<Integer> filts = new ArrayList<>();
        findTiltRecursion(root,filts);
        int filtOfTree = 0;
        for (int i = 0; i < filts.size(); i++) {
            filtOfTree += filts.get(i);
        }
        return filtOfTree;
    }

    private int findTiltRecursion(TreeNode root,List<Integer> filts) {
        if(root == null){
            return 0;
        }
        int left = findTiltRecursion(root.left,filts);
        int right = findTiltRecursion(root.right,filts);
        filts.add(Math.abs(left -right));
        return left + right + root.val;
    }
}
