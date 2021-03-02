package leetcode.offer;

/**
 * 4. 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 */
public class Offer4 {
    /**
     * 暴力解法
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 利用数组排好序的特性解
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        // 数组为空、行数为空、列数为空，直接返回 false
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int totalRows = matrix.length;
        int row = 0, columns = matrix[0].length - 1;

        // 1、因为数组是有序的，按照有序规则，从右上方开始寻找
        // 2、如果当前位置元素等于 target，直接返回 true
        // 3、如果当前位置元素 matrix[row][columns] 比 target 小，则 matrix[row][columns] 左边的元素都比 target 小，往下寻找， row + 1
        // 4、如果当前位置元素 matrix[row][columns] 比 target 大，则 matrix[row][columns] 下边的元素都比 target 大，往左寻找，columns - 1
        while (row < totalRows && columns >= 0) {
            if (matrix[row][columns] == target) {
                return true;
            } else if (matrix[row][columns] < target) {
                row++;
            } else {
                columns--;
            }
        }
        return false;
    }
}
