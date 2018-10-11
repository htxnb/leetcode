package leetcode.tree;

import java.util.List;

/**
 * @ClassName NTreeNode
 * @Author htx
 * @Date 2018/9/23 15:55
 * @Version 1.0
 **/
public class NTreeNode {
    public int val;
    public List<NTreeNode> children;

    public NTreeNode() {}

    public NTreeNode(int _val,List<NTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
