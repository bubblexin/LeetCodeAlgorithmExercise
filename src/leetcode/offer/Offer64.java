package leetcode.offer;

/**
 * 64.求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10000
 *
 * 因为不能用 if 关键字，所以尝试利用逻辑与运算的特性作为递归函数出口
 */
public class Offer64 {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
