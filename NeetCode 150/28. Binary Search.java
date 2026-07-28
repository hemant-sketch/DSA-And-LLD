class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1 && nums[0]==target) return 0;
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}
