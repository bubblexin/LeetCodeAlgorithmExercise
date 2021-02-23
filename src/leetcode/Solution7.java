package leetcode;

/**
 * 7、整数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 输入：x = 123
 * 输出：321
 *
 * 输入：x = 0
 * 输出：0
 *
 * 提示：-231 <= x <= 231 - 1
 *
 * 解题思路：
 * 通过循环将数字x的每一位拆开，在计算新值时每一步都判断是否溢出。
 * 溢出有两个方向，一个是大于整数最大值（2147483647），一个是小于整数最小值（-2147483648）
 * 初始化新整数 ans 为 0，对整数 x 做循环，循环中依次取整数个位 pos，新整数×10 + pos 得到新的中间值
 * 一直 while 循环到 x 为 0
 */
public class Solution7 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10; // 求当前数的个位

            // 判断向上溢出（大于正数最大值）
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            // 判断向下溢出（小于负数最小值）
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            ans = ans * 10 + pop; // 当前反转过的值*10 再加下一位
            x /= 10; // 去除个位
        }
        return ans;
    }
}
