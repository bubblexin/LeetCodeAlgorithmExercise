package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 57 - II. 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 * <p>
 * 9
 * 1 + 2
 * 1 + 2 + 3
 * 1 + 2 + 3 + 4
 * 2 + 3 + 4 add
 * 3 + 4 = 7
 * 3 + 4 + 5 = 12
 * 4 + 5 = 9 add
 * 4 + 4 l == r return  此时 r 处于 target/2 + 1 = 4 的位置，所以 l < r 的时候 l + r 永远大于 target
 * <p>
 * 15
 * 1 + 2 = 3
 * 1 + 2 + 3 = 6
 * 1 + 2 + 3 + 4 = 10
 * 1 + 2 + 3 + 4 + 5 = 15 add
 * 2 + 3 + 4 + 5 + 6 = 20
 * 3 + 4 + 5 + 6 = 18
 * 4 + 5 + 6 = 15 add
 * 5 + 6 = 11
 * 5 + 6 + 7 = 18
 * 6 + 7 = 13
 * 6 + 7 + 8 = 21
 * 7 + 8 = 15 add
 * 8 + 8 l == r  return
 */
public class Offer57II {
    /**
     * 运用等差数列求和公式求 sum
     * n*(a1+an)/2 == target
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        for (int l = 1, r = 2; l < r; ) {
            int sum = (r - l + 1) * (l + r) / 2;
            if (sum > target) {
                // 和大于 target，则证明以 l 为起点，不存在一个连续序列相加到 r 和为 target，则 r 不变，l 向前移动
                l++;
            } else if (sum < target) {
                // 和小于 target，则证明以 l 为起点，不存在一个连续序列相加到 r 和为 target，则 l 不变，r 向前移动
                r++;
            } else {
                // 正确答案，将其存入 List
                int[] temp = new int[r - l + 1];
                // 从左向右开始循环，i - l 作为数组下标
                for (int i = l; i <= r; i++) {
                    temp[i - l] = i;
                }
                result.add(temp);
                // 以 l 为左起点，不可能再有一组数，和为 target，所以 l++
                l++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public int[][] findContinuousSequence2(int target) {
        List<int[]> vet = new ArrayList<>();
        for (int l = 1, r = 2; l < r; ) {
            int sum = (r - l + 1) * (l + r) / 2;
            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    temp[i - l] = i;
                }
                vet.add(temp);
                l++;
            }
            if (sum > target) {
                l++;
            } else {
                r++;
            }
        }
        return vet.toArray(new int[vet.size()][]);
    }
}
