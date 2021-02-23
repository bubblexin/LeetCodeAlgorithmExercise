package leetcode.offer;

/**
 * 58.左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 限制：
 * <p>
 * 1 <= k < s.length <= 10000
 */
public class Offer58 {
    /**
     * 使用 String 的切片函数
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords1(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * 不允许使用切片函数
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        StringBuilder builder = new StringBuilder();
//        for (int i = n; i < s.length(); i++)
//            builder.append(s.charAt(i));
//        for (int i = 0; i < n; i++)
//            builder.append(s.charAt(i));

        // 利用求余可简化上边的运算
        for (int i = n; i < n + s.length(); i++)
            builder.append(s.charAt(i % s.length()));

        return builder.toString();
    }

    /**
     * 只能使用 String
     * 因为字符串为不可变对象，每轮都要新建字符串，因此效率低下
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords3(String s, int n) {
        String res = "";
        for (int i = n; i < n + s.length(); i++) {
            res += s.charAt(i % s.length());
        }

        return res;
    }
}
