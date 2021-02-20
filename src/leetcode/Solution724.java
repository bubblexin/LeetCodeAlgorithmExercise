package leetcode;

import java.util.Arrays;

/**
 * 724.寻找数组的中心索引
 * https://leetcode-cn.com/problems/find-pivot-index/
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
 *
 * 注意：中心索引可能出现在数组的两端。
 */
public class Solution724 {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int total = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (2 * leftSum + nums[i] == total) {
                return i;
            }
            leftSum += nums[i];
        }

        // 左侧和 + 右侧和 + num[i]（中间节点的值） = 数组的和
        // 等价于两倍的左侧和 + num[i] = 数组和，也就是求出 i 即可
//        leftSum + rightSum + nums[i] = sum
//        2*leftSum+nums[i]=sum;
        return -1;
    }
}
