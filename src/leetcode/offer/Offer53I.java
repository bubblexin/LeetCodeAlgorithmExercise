package leetcode.offer;

/**
 * 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Offer53I {
    /**
     * 遍历法
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            // 遍历数组，发现等于 target 的元素时，从 i 位置开始继续遍历
            if (nums[i] == target) {
                // 从 i 遍历到 length
                for (int j = i; j < nums.length; j++) {
                    // 遇到不相等的元素时，return j - i
                    if (nums[j] != target) {
                        return j - i;
                    } else if (j == nums.length - 1) {
                        // 否则说明遍历到了最后，则长度为 j - i + 1
                        return j - i + 1;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 利用二分查找法
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * 循环执行二分法：
     * 1.计算中点 m = (i + j) / 2m=(i+j)/2 （向下取整）
     * 2.若 nums[m] < target ，则 target 在闭区间 [m + 1, j] 中，因此执行 i = m + 1；
     * 3.若 nums[m] > target ，则 target 在闭区间 [i, m - 1] 中，因此执行 j = m - 1；
     * 4.若 nums[m] = target ，则右边界 right 在闭区间 [m+1, j] 中；左边界 left 在闭区间 [i, m-1] 中。因此分为以下两种情况：
     *      1.若查找 右边界 right ，则执行 i = m + 1 ；（跳出时 i 指向右边界）
     *      2.若查找 左边界 left ，则执行 j = m - 1 ；（跳出时 j 指向左边界）
     *
     * 使用二分法循环找左右边界（区间左右两边的位置），找到后 right - left - 为最终值
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        // 查找右边界
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int index = (i + j) / 2;
            if (nums[index] > target) j = index - 1;
            else if (nums[index] <= target)
                i = index + 1; // nums[index] == target 时，证明右边界在 [index,j] 闭区间，这个循环是为了寻找右边界，则 i = index + 1
        }
        int right = i;
        // 此时 j 在 i 的右边，也就是 j 在我们查找的 target 数组中，如果此时 j>=0，且 nums[j]!=target，证明数组中没有 target，提前返回
        if (j >= 0 && nums[j] != target) return 0;
        // 查找左边界
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int index = (i + j) / 2;
            if (nums[index] < target) i = index + 1;
            else if (nums[index] >= target)
                j = index - 1; // nums[index] == target 时，证明左边界在 [i,index] 闭区间，这个循环是为了寻找左边界，则 j = index - 1
        }
        int left = j;
        return right - left - 1;
    }

    /**
     * 寻找 target 的右边数的 index，减去 target - 1 的右边数的 index，即为所求
     * @param nums
     * @param target
     * @return
     */
    public int search3(int[] nums, int target) {
        return findRightPosition(nums, target) - findRightPosition(nums, target - 1);
    }

    public int findRightPosition(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int index = (i + j) / 2;
            if (nums[index] <= target) i = index + 1;
            else j = index - 1;
        }
        return i;
    }
}
