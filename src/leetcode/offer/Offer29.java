package leetcode.offer;

/**
 * 29. 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        // 1.数组为空的情况
        if (matrix.length == 0)
            return new int[0];
        // 2.定义左上右下四个边界
        int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1, index = 0;
        // 3.定义存放结果的数组（返回值不算空间复杂度）
        int[] result = new int[matrix.length * matrix[0].length];

        // 4.开始循环处理每个 “从左向右、从上向下、从右向左、从下向上” 循环
        //     1.根据边界打印，按顺序将元素添加到 result[] 尾部
        //     2.边界收缩
        //     3.判断是否打印完毕（即边界是否相遇），打印完毕则跳出
        while (true) {
            // 从左到右打印
            for (int i = left; i <= right; i++) result[index++] = matrix[top][i];
            if (++top > bottom) break;

            // 从上到下打印
            for (int i = top; i <= bottom; i++) result[index++] = matrix[i][right];
            if (left > --right) break;

            // 从右向左打印
            for (int i = right; i >= left; i--) result[index++] = matrix[bottom][i];
            if (top > --bottom) break;

            // 从下向上打印
            for (int i = bottom; i >= top; i--) result[index++] = matrix[i][left];
            if (++left > right) break;
        }
        return result;
    }
}
