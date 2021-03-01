package leetcode.offer;

/**
 * 17. 打印从1到最大的n位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * 题解：
 * 需要找出 n 和最大的 n 位数之间的关系
 * n = 1,max = 9
 * n = 2,max = 99
 * n = 3,max = 999
 * 也就是对十求 n 次幂 - 1 为 max 的值，只需要遍历到 max 值，每次 +1 存入数组即可
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n) - 1;
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
