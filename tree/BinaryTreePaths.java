package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * @ClassName BinaryTreePaths
 * @Author htx
 * @Date 2018/10/10 17:15
 * @Version 1.0
 **/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        String path = "";
        findTreePaths(root,path,paths);
        return paths;
    }

    private void findTreePaths(TreeNode root, String path,List<String> paths) {
        if(root != null){
            if(path == ""){
                path += root.val;
            }else{
                path += "->"+root.val;
            }

            if(root.left == null && root.right == null){
                paths.add(path);
            }

            findTreePaths(root.left,path,paths);
            findTreePaths(root.right,path,paths);
        }
        
            
            
    }
}
