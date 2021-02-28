package leetcode.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 56 - I. 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * <p>
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 * 限制：
 * <p>
 * 2 <= nums.length <= 10000
 */
public class Offer56I {
    public int[] singleNumbers(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // map 里不包含 nums[i]，就 put 进去
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                // map 里存在 nums[i]，remove 掉
                map.remove(nums[i]);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            result[i] = entry.getKey();
            i++;
        }
        return result;
    }

    /**
     * 当数组中只有一个元素是独立不成对时，数组中各元素异或的结果就是该元素
     * 一个数与自己异或结果为 0，与 0 异或结果为本身
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers2(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }

        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return new int[]{ret};
    }

    /**
     * 利用 singleNumbers2 的思维，将数组分成两组，满足以下条件，分组求异或结果就可得出两个数：
     *      1.两个独立数在不同的组中
     *      2.相同的数分在相同的组里
     * 由 singleNumbers2 中可得出，数组所有元素的异或结果就为两个独立数字异或的结果 ret，设其中一个二进制位为 x[i]，则由异或的特性可得出，x[i] == 1 时
     * 两个数组这一位是不等的，所以按照这个规则分组，我们设 int div = 1，循环与 ret 求与运算，找到一个为 1 的位。然后将 dev 与数组中的元素分别做与运算
     * 此时两个独立数必然在不同的分组里，且相同的数肯定会进入到同一组
     * @param nums
     * @return
     */
    public int[] singleNumbers3(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }

        int ret = 0;
        // 求出两个独立数的异或结果
        for (int num : nums) {
            ret ^= num;
        }

        // 在两个独立数的异或结果 ret 中找出最低的为 1 的位（任意位都行，这里找最低的）
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        // 开始分组异或
        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
