package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：给定一个N叉树，返回其节点值的后序遍历。
 * 例如，给定一个 3叉树 :
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗
 * @ClassName NTreePostOrderTraversal
 * @Author htx
 * @Date 2018/9/23 15:54
 * @Version 1.0
 **/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
public class NTreePostOrderTraversal {
    /**
     * n叉树的深度和前根遍历以及后根遍历和二叉树的原理一样，都可以用递归解决，只是二叉树只对两个孩子结点递归，n叉树需要遍历多个孩子
     * @param root
     * @return
     */
    public List<Integer> postorder(NTreeNode root) {
        ArrayList<Integer> traversalResults = new ArrayList<>();
        doPostOrder(root,traversalResults);
        return traversalResults;
    }

    private void doPostOrder(NTreeNode root, ArrayList<Integer> traversalResults) {
        if(root != null){
            for (int i = 0; i < root.children.size(); i++) {
                doPostOrder(root.children.get(i),traversalResults);
            }
            traversalResults.add(root.val);
        }

    }
}

