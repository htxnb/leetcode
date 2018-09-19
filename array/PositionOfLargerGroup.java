package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * 最终结果按照字典顺序输出。
 * 示例 1:
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2:
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3:
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 * 说明:  1 <= S.length <= 1000
 * @ClassName PositionOfLargerGroup
 * @Author htx
 * @Date 2018/9/15 21:40
 * @Version 1.0
 **/
public class PositionOfLargerGroup {
    /**
     * 思路是left(前指针)，right(后指针)指针遍历数组;若前后指针指向元素相等，则right++，且若right-left +1==3的时候，标志位置为true;
     * 不等则更新两个指针位置；当不等且标志位为true时，输出left,right(代表一个较大数组)，然后更新left,right指针
     * @param S
     * @return
     */
    public static List<List<Integer>> largeGroupPositions(String S) {
        int left = 0,right = 1;
        char[] chars = S.toCharArray();
        boolean isAdd = false;
        List<List<Integer>> lists = new ArrayList<>();
        while(right <= chars.length){
            //添加条件right == chars.length是为了较大分组在末尾
            if(right == chars.length || chars[left] != chars[right]){
                if(isAdd){
//                    添加较大分组
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right - 1);
                    lists.add(list);
//                    更新指针和标志位
                    isAdd = false;
                    left = right;
                    right++;
                    continue;
                }
                right++;
                left = right -1;
            }else {
//                满足条件时，将标志位置为true
                if(right - left + 1 == 3){
                    isAdd = true;
                }
                right++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        String s = "bababbabaa";
        List<List<Integer>> lists = largeGroupPositions(s);
        for(List list: lists){
            System.out.println(list);
        }
    }
}
