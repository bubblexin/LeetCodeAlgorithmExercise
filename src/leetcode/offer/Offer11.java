package leetcode.offer;

/**
 * 11. 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 */
public class Offer11 {
    /**
     * 暴力解法
     *
     * @param numbers
     * @return
     */
    public int minArray1(int[] numbers) {
        int num = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                num = numbers[0];
                break;
            }
            if (numbers[i + 1] > numbers[i]) {
                num = numbers[i + 1];
                break;
            }
        }
        return num;
    }

    /**
     * 二分法
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left != right) {
            // m 是向下取整，所以 start < m < end
            int m = (left + right) / 2;
            // 中间节点小于后边节点，则证明 m 在右侧升序序列中，则将 m 赋值给 last 指针
            if (numbers[m] < numbers[right]) {
                right = m;
            } else if (numbers[m] > numbers[right]) {
                // 中间节点大于后边节点，则证明 m 在左侧升序序列中，则将 m + 1 赋值给 start 指针
                left = m + 1;
            } else {
                // 中间节点等于后边节点，无论 numbers[right] 是不是最小值，都有另一个替代品，所以这里忽略 numbers[right] 不影响，right - 1
                right -= 1;
            }
        }
        return numbers[left];
    }
}
