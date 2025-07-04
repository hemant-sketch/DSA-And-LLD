// https://www.geeksforgeeks.org/problems/pair-in-array-whose-sum-is-closest-to-x1124/0

// TC = O(N)
// SC = O(1)

class Solution {
    public List<Integer> sumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int minAbsDiff = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();

        while (left < right) {
            int sum = nums[left] + nums[right];
            int currentAbsDiff = Math.abs(sum - target);
            int currentPairAbsDiff = Math.abs(nums[right] - nums[left]);

            if (currentAbsDiff < minAbsDiff) {
                minAbsDiff = currentAbsDiff;
                result.clear();
                result.add(nums[left]);
                result.add(nums[right]);
            } else if (currentAbsDiff == minAbsDiff) {
                if (currentPairAbsDiff > Math.abs(result.get(1) - result.get(0))) {
                    result.clear();
                    result.add(nums[left]);
                    result.add(nums[right]);
                }
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
