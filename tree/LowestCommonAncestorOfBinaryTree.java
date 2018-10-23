package algorithm.leetcode.tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 问题描述：
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * @ClassName LowestCommonAncestorOfBinaryTree
 * @Author htx
 * @Date 2018/10/17 15:52
 * @Version 1.0
 **/
public class LowestCommonAncestorOfBinaryTree {
    /**
     * 最初的递归版本
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null ||q == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
        if(leftResult != null && rightResult != null){
            return root;
        }
        return leftResult == null ? rightResult:leftResult;
    }

    /**
     * 利用缓存对上一个解法的优化，减少单条查询所用时间
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parentOfNodes = new HashMap<>();
        parentOfNodes.put(root,null);
//        表里存的有所有节点及其父节点的映射
        setParents(root,parentOfNodes);
        HashSet<TreeNode> parentsOfP = getParents(p, parentOfNodes);
        TreeNode parentOfQ = q;
        while(parentOfNodes.containsKey(parentOfQ)){
            if(parentsOfP.contains(parentOfQ)){
                break;
            }else{
                parentOfQ = parentOfNodes.get(parentOfQ);
            }
        }
        return parentOfQ;
    }

    private HashSet<TreeNode> getParents(TreeNode p, HashMap<TreeNode, TreeNode> parentOfNodes) {
        if(p == null){
            return null;
        }
        HashSet<TreeNode> parents = new HashSet<>();
        while (parentOfNodes.containsKey(p)){
            parents.add(p);
            p = parentOfNodes.get(p);
        }
        return parents;
    }

    private void setParents(TreeNode root, HashMap<TreeNode, TreeNode> parentOfNodes) {
        if(root == null){
            return;
        }
        if(root.left != null){
            parentOfNodes.put(root.left,root);
        }
        if(root.right != null){
            parentOfNodes.put(root.right,root);
        }
        setParents(root.left, parentOfNodes);
        setParents(root.right, parentOfNodes);
    }


}
