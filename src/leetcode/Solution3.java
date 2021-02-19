package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3.无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * <p>
 * 我的思路：
 * 1.创建一个记录最长字符串的长度的变量，一个保存当前最长无重复字符串的 StringBuilder curStr
 * 2.遍历字符串，取当前位置的 char，看其在 curStr 中是否存在
 * 3.不存在，则 append 加上去，同时取 maxLength 和当前 curStr 的长度的最大值重新赋值给 maxLength、
 * 4.存在，则删除 curStr 从 0 到重复的 char 出现的位置的字符串，同时 append 新的 char 进去
 * 5.返回 maxLength
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        StringBuilder curStr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            // 数组里没有
            if (curStr.indexOf(Character.toString(curChar)) == -1) {
                curStr.append(curChar);
                maxLength = Math.max(maxLength, curStr.length());
            } else {
                int index = curStr.indexOf(Character.toString(curChar));
                curStr.delete(0, index + 1);
                curStr.append(curChar);
            }
        }

        return maxLength;
    }

    /**
     * 滑动窗口法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int maxLength = 0; // 定义字符串最大长度
        Set<Character> windowSet = new HashSet<>(); // 定义窗口集合
        int n = s.length();
        int endIndex = 0; // 窗口索引的下一位，从 i 到 endIndex 之间没有重复字符串
        for (int i = 0; i < n; i++) {

            // 当 i 不为 0 时，每次遇到重复的跳出 while 循环之后，i + 1 之后，右移左光标，将窗口最左边元素删除
            if (i != 0) {
                windowSet.remove(s.charAt(i - 1));
            }

            // 判断当 endIndex 小于字符串长度，并且 endIndex 位置的字符串在窗口中没有时，加进窗口
            while (endIndex < n && !windowSet.contains(s.charAt(endIndex))) {
                windowSet.add(s.charAt(endIndex));
                endIndex++;
            }

            // 每次跳出 while 循环，判断窗口长度和之前保存的最大长度
            maxLength = Math.max(maxLength, endIndex - i);
        }

        return maxLength;
    }
}
