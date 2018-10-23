package algorithm.leetcode.tree;

import java.util.*;

/**
 * 问题描述：
 * 给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。
 * 示例 1
 * 输入:
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 * 示例 2
 * 输入:
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
 * @ClassName MostFrequentSubtreeSum
 * @Author htx
 * @Date 2018/10/22 15:11
 * @Version 1.0
 **/
public class MostFrequentSubtreeSum {
    /**
     * 思路：递归，计算每一颗子树的子树元素和，并添加到hashmap中
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        findFrequentTreeSumRecursion(root,hashMap);
//        统计最大出现次数
        Set<Integer> keySet = hashMap.keySet();
        int count = 1,max = Integer.MIN_VALUE;
        for(Integer i:keySet){
            if(hashMap.get(i) > max){
                max = hashMap.get(i);
                count = 1;
            }else if(hashMap.get(i) == max){
                count++;
            }
        }
//        将最多子树元素和填充到数组中
        int[] frequentTreeSum = new int[count];
        int index= -1;
        for(Integer i:keySet){
            if(hashMap.get(i) == max){
                frequentTreeSum[++index] = i;
            }
        }
        return frequentTreeSum;
    }

    private int findFrequentTreeSumRecursion(TreeNode root, HashMap<Integer, Integer> hashMap) {
        if(root == null){
            return 0;
        }
        int left = findFrequentTreeSumRecursion(root.left,hashMap);
        int right = findFrequentTreeSumRecursion(root.right,hashMap);
        int frequentTreeSum = left+right+root.val;
        if(!hashMap.containsKey(frequentTreeSum)){
            hashMap.put(frequentTreeSum,1);
        }else{
            hashMap.replace(frequentTreeSum,hashMap.get(frequentTreeSum)+1);
        }
        return frequentTreeSum;
    }
}
