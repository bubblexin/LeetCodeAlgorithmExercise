package leetcode.offer;

import leetcode.Utils.Utils;

import java.util.Arrays;

/**
 * 21.调整数组顺序使奇数位于偶数前面
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * <p>
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class Offer21 {
    /**
     * 双指针法
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 如果是奇数，left++，跳过此次循环
            if (nums[left] % 2 != 0) {
                left++;
                continue;
            }

            // 如果是偶数，right--，跳过此次循环
            if (nums[right] % 2 == 0) {
                right--;
                continue;
            }
            // 走到这里了，说明 num[left] 是偶数，num[right] 是奇数，交换两数位置，同时 left++，right--
            Utils.swapIntArrayElement(nums, left++, right--);
        }
        return nums;
    }

    /**
     * 快慢指针法
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        int low = 0, fast = 0;
        while (fast < nums.length) {
            // 如果 fast 指向奇数，则交换 low 和 fast
            if (nums[fast] % 2 != 0) {
                int temp = nums[low];
                nums[low] = nums[fast];
                nums[fast] = temp;
                // low++ 指向下一位，low 指向的位置都被 fast 检查过了，所以 low 指向的元素肯定是偶数
                low++;
            }
            fast++;
        }
        return nums;
    }
}
