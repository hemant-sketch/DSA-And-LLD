// Lc 16
// https://leetcode.com/problems/3sum-closest/description/

// TC = O(N^2)
// SC = O(logN) // quick sort jo use hora hai arrasy.sort mein

class Solution {
    public int twoSumClosest(int[] nums, int left, int target) {
        int right = nums.length - 1;
        int closestSum = Integer.MAX_VALUE;
        int minAbsDiff = Integer.MAX_VALUE;

        while (left < right) {
            int sum = nums[left] + nums[right];
            int currentDiff = Math.abs(sum - target);

            if (sum == target) {
                return sum;
            }

            if (currentDiff < minAbsDiff) {
                minAbsDiff = currentDiff;
                closestSum = sum;
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return closestSum;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int minAbsDiff = Math.abs(ans - target);

        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int twoSumResult = twoSumClosest(nums, first + 1, target - nums[first]);
            int currentThreeSum = nums[first] + twoSumResult;
            int currentAbsDiff = Math.abs(currentThreeSum - target);

            if (currentAbsDiff < minAbsDiff) {
                minAbsDiff = currentAbsDiff;
                ans = currentThreeSum;
            }
            
            if (minAbsDiff == 0) {
                return ans;
            }
        }
        return ans;
    }
}
