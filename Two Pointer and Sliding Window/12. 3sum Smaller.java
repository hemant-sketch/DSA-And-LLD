// https://www.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1

// TC = O(N^2)
// SC = O(1)

class Solution {

    public long twoSumSmaller(long[] arr, int left, long target) {
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

        for (int first = 0; first < arr.length - 2; first++) {
            long remainingSum = (long)sum - arr[first];
            totalTriplets += twoSumSmaller(arr, first + 1, remainingSum);
        }
        return totalTriplets;
    }
}
