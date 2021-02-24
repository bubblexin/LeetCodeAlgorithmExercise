package leetcode;

import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] nums) {
        // copy 一份数组，不改变原数组内容
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < arr.length; i++) {
            // 设置标记位，若此次没有交换，则证明已经有序
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
