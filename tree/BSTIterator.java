package algorithm.leetcode.tree;

import data_structure.tree.TreeNode;

/**
 * 二叉搜索树迭代器
 * 问题描述:
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * 注意: next() 和hasNext() 操作的时间复杂度是O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * @ClassName BSTIterator
 * @Author htx
 * @Date 2018/10/11 10:15
 * @Version 1.0
 **/
public class BSTIterator {
    public BSTIterator(TreeNode root) {

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        return 0;
    }
}
