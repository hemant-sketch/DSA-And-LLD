// https://www.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1

// TC = O(N^2)
// SC = O(1)

class Solution {

    public long twoSumSmaller(long[] arr, int startIdx, long target) {
        int left = startIdx;
        int right = arr.length - 1;
        long count = 0;

        while (left < right) {
            long currentSum = arr[left] + arr[right];
            if (currentSum < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    long countTriplets(int n, int sum, long arr[]) {
        Arrays.sort(arr);
        long totalTriplets = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            long remainingSum = (long)sum - arr[i];
            totalTriplets += twoSumSmaller(arr, i + 1, remainingSum);
        }
        return totalTriplets;
    }
}
