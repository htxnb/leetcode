package algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 问题描述；
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * 提示：
 * 给定的两颗树可能会有 1 到 100 个结点。
 * @ClassName LeafSimilarTrees
 * @Author htx
 * @Date 2018/10/17 22:22
 * @Version 1.0
 **/
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> leafRoot1 = getLeaf(root1);
        List<TreeNode> leafRoot2 = getLeaf(root2);
        return equals(leafRoot1,leafRoot2);
    }

    private boolean equals(List<TreeNode> leafRoot1, List<TreeNode> leafRoot2) {
        if(leafRoot1.size() != leafRoot2.size()){
            return false;
        }
        int index = 0;
        int size = leafRoot1.size();
        while(index < size){
            if(leafRoot1.get(index).val != leafRoot2.get(index).val){
                return false;
            }
            index++;
        }
        return true;
    }

    private List<TreeNode> getLeaf(TreeNode root) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        getLeafRecursion(root,treeNodes);
        return treeNodes;
    }

    private void getLeafRecursion(TreeNode root, LinkedList<TreeNode> treeNodes) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            treeNodes.add(root);
        }
        getLeafRecursion(root.left,treeNodes);
        getLeafRecursion(root.right,treeNodes);
    }

}
