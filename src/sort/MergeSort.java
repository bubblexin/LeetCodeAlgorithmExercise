package sort;

public class MergeSort {
    // 自上而下的递归
    // O(nlogn)
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1;

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, index = 0;

        while (i <= mid && j <= right) temp[index++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

        while (i <= mid) temp[index++] = arr[i++];
        while (j <= right) temp[index++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
