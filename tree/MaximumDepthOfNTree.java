package leetcode.tree;

/**
 * 问题描述:
 * 给定一个N叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * 例如，给定一个 3叉树 :
 * 我们应返回其最大深度，3。
 * 说明:
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 * @ClassName MaximumDepthOfNTree
 * @Author htx
 * @Date 2018/10/10 16:22
 * @Version 1.0
 **/
public class MaximumDepthOfNTree {
    public int maxDepth(NTreeNode root) {
        if(root != null){
            if(root.children.size() == 0){
                return 1;
            }else{
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < root.children.size(); i++) {
                    int depth = maxDepth(root.children.get(i));
                    max = Math.max(max,depth);
                }
                return 1 + max;
            }

        }
        return 0;
    }
}
