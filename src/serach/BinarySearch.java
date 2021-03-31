package serach;

/**
 * 二分查找
 */
public class BinarySearch {
    public int binarySearch(int nums[], int target) {
        if (nums == null || nums.length == 0) return -1;

        int pivot = 0, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (nums[pivot] < target) left = pivot + 1;
            else right = pivot - 1;
        }
        return -1;
    }
}
