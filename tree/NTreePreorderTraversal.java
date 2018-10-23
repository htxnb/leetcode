package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个N叉树，返回其节点值的前序遍历。
 * 例如，给定一个 3叉树 :
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗
 * @ClassName NTreePreorderTraversal
 * @Author htx
 * @Date 2018/9/23 15:52
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
public class NTreePreorderTraversal {
    public List<Integer> preorder(NTreeNode root) {
        ArrayList<Integer> traversalResults = new ArrayList<>();
        doPreoder(root,traversalResults);
        return traversalResults;
    }

    private void doPreoder(NTreeNode root, ArrayList<Integer> traversalResults) {
        if(root != null){
            traversalResults.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                doPreoder(root.children.get(i),traversalResults);
            }
        }

    }
}
