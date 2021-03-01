package leetcode.offer;

import java.util.*;

/**
 * 50. 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * <p>
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 *
 * 解题思路：
 * 两种解法：
 * 1.利用有序的 HashMap -- LinkedHashMap
 * 2.利用无序字符串 + 字符串遍历，两次遍历字符串，第一次向 Map 中添加元素，第二次再遍历字符串，找到第一个在 map 中满足条件的 char
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, -1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
