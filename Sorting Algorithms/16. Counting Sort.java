// bigegr values aur scattered values pe count sort work nhi krta
// TC = O(N+D)    // D is the size of an array
// SC = O(N)
// not in place
// not stable
class Solution {
    public int[] sortArray(int[] nums) {
        int min = -50000;
        int max = 50000;
        int[] freq = new int [max - min + 1];

        for(int ele : nums){
            freq[ele - min]++;
        }

        int idx = 0;
        for(int ele = min; ele < max; ele++){
            while(freq[ele - min] > 0){
                nums[idx++] = ele;
                freq[ele - min]--;
            }
        }   
        return nums;
    }

}

