// https://www.geeksforgeeks.org/problems/merge-sort/1

// TC = O(N*logN)
// SC = O(N)

// not inplace

class Solution {
    public void merge(int[] arr, int left, int mid, int right) {
        int[] res = new int[right - left + 1];
        int idx1 = left, idx2 = mid + 1, idx3 = 0;

        while (idx1 <= mid && idx2 <= right) {
            if (arr[idx1] <= arr[idx2]) {
                res[idx3++] = arr[idx1++];
            } else {
                res[idx3++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            res[idx3++] = arr[idx1++];
        }

        while (idx2 <= right) {
            res[idx3++] = arr[idx2++];
        }

        for (int idx = left; idx <= right; idx++) {
            arr[idx] = res[idx - left];
        }
    }

    void mergeSort(int nums[], int left, int right) {
        if (left == right)
            return;

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
}
