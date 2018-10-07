package leetcode.bitManipulation;

/**
 * 问题描述：
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * @ClassName HammingDistance
 * @Author htx
 * @Date 2018/9/19 17:08
 * @Version 1.0
 **/
public class HammingDistance {
    /**
     * 两个数异或得到的结果中二进制表示1的个数就是两个数的汉明距离，
     * 所以接下来统计一下异或结果二进制表示中的1的个数
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int number = 0;
        while(result > 0){
            if(result % 2 == 1){
                number++;
            }

            result = result>>1;
        }
        return number;
    }
}
