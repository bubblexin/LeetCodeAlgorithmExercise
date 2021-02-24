package leetcode;

import java.util.Arrays;

public class SelectSort {
    public void sort(int[] nums) {
        // copy 一份数组，不改变原数组内容
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
