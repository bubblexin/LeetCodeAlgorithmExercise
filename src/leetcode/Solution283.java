package leetcode;

/**
 * 283.移动 0
 * https://leetcode-cn.com/problems/move-zeroes/
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 当 i == j 时，会有多余交换的行为
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }
    }

    /**
     * 优化解法
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 此处避免了 i==j 时的非零元素的无用交换
                if (i > j) {
                    // 此处将交换操作换成了单纯的赋值操作，减少了一条操作语句，理论上更节省时间
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                // 只要满足 nums[i] != 0，j 就应该 ++
                j++;
            }
        }
    }
}
