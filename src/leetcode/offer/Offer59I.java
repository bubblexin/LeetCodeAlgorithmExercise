package leetcode.offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 59 - I. 滑动窗口的最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * <p>
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3   size = 8   i = k;i < size;i++
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * 本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class Offer59I {
    /**
     * 1.设数组长度为 n，则窗口有 n - k + 1 个。声明 int result[n - k + 1] 用于存放结果
     * 2.声明数组 temp[k]，用于将每次窗口的数据复制到 temp 中
     * 3.for 循环，i 从 0 到 n - k + 1，即循环窗口个数次，每次将 [i,k] 区间中的数复制到 temp 中
     * 4.对 temp 排序，取最后一位（即排序后的最大值）放入 result[i] 中
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        if (size == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[size - k + 1];
        int[] temp = new int[k];
        for (int i = 0; i < size - k + 1; i++) {
            System.arraycopy(nums, i, temp, 0, k);
            Arrays.sort(temp);
            result[i] = temp[k - 1];
        }

        return result;
    }

    /**
     * [i,j] 每个区间 j - i + 1 = k 个数
     * 左边界范围 i ∈ [1  - k, n - k]
     * 右边界范围 j ∈ [0, n - 1]
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            // 队列不为空，且队列中最后一个元素小于 nums[i]，则将 last remove 掉
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            // 否则加进队列
            deque.addLast(nums[i]);
        }
        // 窗口形成后，队头肯定是最大的元素，add 到 result[0] 中
        result[0] = deque.peekFirst();
        // 形成窗口后
        for (int i = k; i < nums.length; i++) {
            // 若上一次窗口的队头就是最大值，则需要将其手动移除
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            // 否则加进队列
            deque.addLast(nums[i]);
            result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }
}
