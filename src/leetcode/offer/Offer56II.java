package leetcode.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 56 - II. 数组中数字出现的次数 II
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * <p>
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 */
public class Offer56II {
    /**
     * 暴力解法，直接遍历
     * 也可以用位运算
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, -1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        int[] counts = new int[32];
        // 求各位 1 的个数
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1; // couts[j] 为对应位置 1 的个数
                num >>>= 1; // 无符号右移一位
            }
        }

        int ret = 0, m = 3;
        for (int i = 0; i < counts.length; i++) {
            ret <<= 1;
            ret |= counts[31 - i] % m;
        }

        return ret;
    }
}
