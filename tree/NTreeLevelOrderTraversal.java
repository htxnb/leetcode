package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 问题描述：
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 例如，给定一个 3叉树 :
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000
 * @ClassName NTreeLevelOrderTraversal
 * @Author htx
 * @Date 2018/10/16 9:53
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
public class NTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(NTreeNode root) {
        List<List<Integer>> treeNodes = new ArrayList<>();
        if(root == null){
            return treeNodes;
        }
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                NTreeNode poll = queue.poll();
                level.add(poll.val);
                for (int j = 0; j < poll.children.size(); j++) {
                    queue.add(poll.children.get(i));
                }
            }
            treeNodes.add(level);
        }
        return treeNodes;
    }
}
