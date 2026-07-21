class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nge = new int[nums.length];
        nge[nums.length-1] = nums.length;
        Stack<Integer> st = new Stack<>();
        st.push(nums.length - 1);

        // -a+
        for(int idx = nums.length-2; idx >=0; idx--) {
            while(st.size() > 0 && nums[idx] > nums[st.peek()]) {
                st.pop();
            }

            if(st.size() == 0) nge[idx] = nums.length;
            else nge[idx] = st.peek();     
            
            st.push(idx);
        }

        int[] ans = new int[nums.length - k + 1];

        for(int idx = 0; idx < nums.length - k + 1; idx++) {
            int j = idx;

            while(nge[j] < idx + k) {
                j = nge[j];
            }

            ans[idx] = nums[j];
        }

        return ans;
    }
}
