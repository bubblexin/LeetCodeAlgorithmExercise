package leetcode;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, index = 0;
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        while (i < m && j < n)
            nums1[index++] = temp[i] < nums2[j] ? temp[i++] : nums2[j++];

        if (i < m)
            System.arraycopy(temp, i, nums1, i + j, m + n - i - j);
        if (j < n)
            System.arraycopy(nums2, j, nums1, i + j, m + n - i - j);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0, index = 0;
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        while (p1 < m && p2 < n) nums1[index++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];

        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }
}
