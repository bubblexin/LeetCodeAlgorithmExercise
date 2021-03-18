package leetcode.offer;

/**
 * Offer 53 - II. 0～n-1中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 10000
 * <p>
 * 题解思路：排序数组中的查找，首先考虑二分法
 */
public class Offer53II {
    public int missingNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0] == 0 ? 1 : 0;
        }
        int left = 0, right = left + 1;
        while (right < nums.length) {
            if (nums[right] - nums[left] > 1) {
                return nums[left] + 1;
            }
            left++;
            right++;
        }
        if (right == nums.length) {
            return right;
        }
        return -1;
    }

    /**
     * 数组可以划分为两部分
     * 左子数组：nums[i] == i
     * 右子数组：nums[j] != j
     * 则，缺失的数字等于右子数组收首位元素索引
     *
     * 初始化 i=0,j=nums.length - 1
     * 当 i <= j 时，循环遍历，当跳出循环时，i 为右子数组首位，j 为左子数组尾部
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int index = (i + j) / 2;
            if (nums[index] == index) i = index + 1;
            else j = index - 1;
        }
        return i;
    }
}
