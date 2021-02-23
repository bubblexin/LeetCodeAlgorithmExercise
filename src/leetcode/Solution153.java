package leetcode;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数都是 唯一 的
 * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
 */
public class Solution153 {

    public int findMin(int[] nums) {
        // 只有一个元素，则就是它自己
        if (nums.length == 1) {
            return nums[0];
        }

        // 右侧数组的最高位大于左侧数组最低位，证明排好序了
        if (nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }

        int pre = 0;
        int last = nums.length - 1;

        while (pre != last) {
            // m 是向下取整，所以 start < m < end
            int m = (pre + last) / 2;
            // 中间节点小于后边节点，则证明 m 在右侧升序序列中，则将 m 赋值给 last 指针
            if (nums[m] < nums[last]) {
                last = m;
            } else {
                // 中间节点大于后边节点，则证明 m 在左侧升序序列中，则将 m + 1 赋值给 start 指针
                pre = m + 1;
            }
        }

        return nums[pre];
    }
}
