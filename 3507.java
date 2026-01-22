//
//

//
//

class Solution {
    public boolean isSorted(int[] nums, int n) {
        for(int idx = 1; idx < n; idx++) {
            if(nums[idx] < nums[idx - 1]) return false;
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        int ans = 0;
        int n = nums.length;
        while(!isSorted(nums, n)) {
            ans++;
            int min = Integer.MAX_VALUE;
            int pos = -1;

            for(int idx = 1; idx < n; idx++) {
                int sum = nums[idx] + nums[idx - 1];
                if(min > sum) {
                    min = sum;
                    pos = idx;
                }
            }

            nums[pos - 1] = min;

            for(int idx = pos; idx < n-1; idx++) {
                nums[idx] = nums[idx + 1];
            }

            n--;
        }
        return ans;
    }
}
