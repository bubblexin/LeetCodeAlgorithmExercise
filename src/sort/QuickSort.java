package sort;

import java.util.Arrays;

import static leetcode.Utils.Utils.swapIntArrayElement;

public class QuickSort {
    public void sort(int[] nums) {
        // copy 一份数组，不改变原数组内容
        int[] arr = Arrays.copyOf(nums, nums.length);

        quickSort(arr, 0, arr.length - 1);
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
}
