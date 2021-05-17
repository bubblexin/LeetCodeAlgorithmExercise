package leetcode.offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 40. 最小的 k个数(Top K 问题)
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]<= 10000
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == arr.length) {
            return arr;
        }
        Arrays.sort(arr);

        return Arrays.copyOfRange(arr, 0, k);
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == arr.length) {
            return arr;
        }
        Queue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                queue.offer(arr[i]);
            } else if (arr[i] > queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        int j = 0;
        int[] result = new int[k];
        for (Integer integer : queue) {
            result[j++] = integer;
        }
        return result;
    }
}
