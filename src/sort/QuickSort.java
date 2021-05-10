package sort;

import java.util.Arrays;

import static leetcode.Utils.Utils.swapIntArrayElement;

/**
 * 快排
 * http://data.biancheng.net/view/117.html
 */
public class QuickSort {
    public void sort(int[] nums) {
        // copy 一份数组，不改变原数组内容
        int[] arr = Arrays.copyOf(nums, nums.length);
//        quickSort(arr, 0, arr.length - 1);
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swapIntArrayElement(arr, i, index);
                index++;
            }
        }
        swapIntArrayElement(arr, pivot, index - 1);
        return index - 1;
    }

    /**
     * 快排采用了分而治之的思想，在一个 list 中，随便找一个基准值（我们这里用数组第一个元素），将数组进行排序，让基准值左边的数都小于它，右边的数都大于他
     * 其实就是求基准值应该在的 index，然后将 list 分为左右两个 list，即 begin ~ (index -1) 和 (index + 1) ~ end 两部分再递归执行以上步骤
     * 当每部分都只剩下一个元素时，数组交换完成，排序完成
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */

    private int[] quickSort2(int[] arr, int left, int right) {
        if (left < right) { // 跳出递归的条件，left == right
            // 每次递归进来都做相同的事情
            int pivot = arr[left]; // 先设数组左边第一位为基准值
            int i = left; // 定义左边开始遍历的 index
            int j = right; // 定义右边开始遍历的 index

            // 开始遍历寻找 pivot 的 index
            while (i < j) {
                // 先从右往左遍历（右边存放大于 pivot 的值），找到一个小于 pivot 的值，将其与 arr[i] 交换
                while (arr[j] > pivot) {
                    j--;
                }
                // 跳出循环，说明找到了一个 arr[j] < pivot，交换 arr[i] 和 arr[j]
                if (i < j) {
                    int temp1 = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp1;
                    // 交换完成，i++
                    i++;
                }

                // 再从左往右遍历（左边存放小于 pivot 的值），找到一个大于 pivot 的值，将其与 arr[j] 交换
                while (i < j && arr[i] < pivot) {
                    i++;
                }

                // 跳出循环，说明找到了一个 arr[i] > pivot，交换 arr[i] 和 arr[j]
                if (i < j) {
                    int temp2 = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp2;
                    // 交换完成，j--
                    j--;
                }
            }
            // 找到这次遍历数组的基准值位置，将 pivot 基准值赋值过去
            arr[i] = pivot;
            quickSort2(arr, left, i - 1);
            quickSort2(arr, i + 1, right);
        }
        return arr;
    }
}
