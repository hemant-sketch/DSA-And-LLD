class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int idx = 0; idx < nums.length; idx++) {
            if(idx > 0 && nums[idx] == nums[idx - 1]){
                continue;
            }

            int left = idx + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[idx] + nums[left] + nums[right];

                if(sum == 0){                    
                    ans.add(Arrays.asList(nums[idx], nums[left], nums[right]));
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }

        return ans;
    }
}
