package leetcode.offer;

/**
 * TODO 用动态规划解
 * 剑指 Offer 10- I. 斐波那契数列
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * <p>
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 */
public class Offer10I {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * f(n+1) = f(n) + f(n - 1)
     * 转移方程：dp[i + 1] = dp[i] + dp[i - 1]
     * 初始状态：dp[0] = 0,dp[1] = 1
     * 返回值：dp[n]，即斐波那契数列第 n 项
     * @param n
     * @return
     */
    public int fib2(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            // f(2) = f(0) + f(1) -> a == f(0) b == f(1)
            sum = (a + b)%1000000007; // f(2) = f(0) + f(1)  对答案取模
            a = b; // a = f(1)
            b = sum;
        }
        return a; // a == f(n)
    }

//    public int fib2(int n) {
//        int[] fib = new int[n];
//        fib[0] = 1;
//        fib[1] = 1;
//        for (int i = 2; i < n; i++) {
//            fib[i] = fib[i - 2] + fib[i - 1];
//        }
//        return fib[n - 1];
//    }
}
