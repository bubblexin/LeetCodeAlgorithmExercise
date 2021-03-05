package leetcode.offer;

/**
 * 57. 和为s的两个数字
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * <p>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 */
public class Offer57 {
    /**
     * 1.定义双指针 pre 和 last，分别指向数组的头和尾
     * 2.从数组两侧开始遍历，若 nums[pre] + nums[last] == target，（使用两个数相加的和有可能导致溢出，所以此处改为用 pre < last 判断循环结束条件）则结束 while 循环
     * 3.否则，因为数组是有序递增的，所以 nums[pre] + nums[last] > target，则另一个加数应该在 last 左边，last--
     * 4.若 nums[pre] + nums[last] < target，则另一个加数应该在 pre 的右边，pre++
     * 5.跳出 while 循环，证明找到了 nums[pre] + nums[last] == target，返回数组中 pre 和 last 位置的元素
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // nums[left] + nums[right] == target 也可以判断循环跳出条件，但有可能导致溢出
        // 所以此处改为使用指针位置判断循环跳出条件
        // 0,1
        // [2,7,11,15]
        //9
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                break;
            }
        }
        return new int[]{nums[left], nums[right]};
    }
}
