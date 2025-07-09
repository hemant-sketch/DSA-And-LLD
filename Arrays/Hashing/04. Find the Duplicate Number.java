// Lc 287
// https://leetcode.com/problems/find-the-duplicate-number/description/

// Index based Hashing
// TC = O(N)
// SC = O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int idx = 0; idx < nums.length; idx++){
            int original  = nums[idx] % (n + 1);
            nums[original-1] += (n + 1);    
        }

        for(int idx = 0; idx < nums.length; idx++){
            int freq = nums[idx] / (n+1);
            if(freq > 1) return idx+1;
        }
        return n;
    }
}

// Flyods Cycle Detection
// TC = O(N)
// SC = O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0; int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }

        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
