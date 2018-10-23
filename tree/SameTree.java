package algorithm.leetcode.tree;

/**
 * @ClassName SameTree
 * @Author htx
 * @Date 2018/10/18 20:41
 * @Version 1.0
 **/
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        boolean leftResult = isSameTree(p.left, q.left);
        boolean rightResult = isSameTree(p.right, q.right);
        return leftResult && rightResult;
    }
}
