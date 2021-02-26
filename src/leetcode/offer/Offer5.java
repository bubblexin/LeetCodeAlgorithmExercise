package leetcode.offer;

/**
 * 5. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 */
public class Offer5 {
    /**
     * 利用 StringBuilder
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
//        return s.replace(" ", "%20");
        return sb.toString();
    }

    /**
     * 用一个字符数组
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        char[] chars = new char[s.length() * 3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = s.charAt(i);
            }
        }
        return new String(chars, 0, size);
    }
}
