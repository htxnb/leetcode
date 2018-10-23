package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 问题描述：
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * 答案中每个树的每个结点都必须有 node.val=0。
 * 你可以按任何顺序返回树的最终列表。
 * 提示：
 * 1 <= N <= 20
 * @ClassName AllPossibleFullBinaryTrees
 * @Author htx
 * @Date 2018/10/22 11:35
 * @Version 1.0
 **/
public class AllPossibleFullBinaryTrees {
    /**
     * 思路：分治思想
     * 可以分析出来满二叉树的个数N只能是奇数，所以对于给定的个数n,一个是根节点，剩下的 n-1分给左右子树，递归进行
     * @param N
     * @return
     */
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<>();
        if(N == 1)//节点数为1时，直接返回根节点
        {
            TreeNode root = new TreeNode(0);
            list.add(root);
            return list;
        }
        for(int i = 1; i < N; i+=2)
        {
            List<TreeNode> lefts = allPossibleFBT(i);//左节点数为i的所有满二叉树组合
            List<TreeNode> rights = allPossibleFBT(N - i - 1);//右节点数为N-i-1的所有满二叉树组合
            for(TreeNode l : lefts)
                for(TreeNode r : rights)
                {
                    //遍历左右子树的组合，排列出所有树
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
        }

        return list;

    }


}
