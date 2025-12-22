//
//

// if you are asked about the coins list
// TC O(N)
// SC O(N)

class Solution {
    public int findMin(int n) {
        List<Integer> res = new ArrayList<>();
        int[] coins = {1,2,5,10};
        
        for(int idx = coins.length-1; idx >= 0; idx--) {
            while(n >= coins[idx]) {
                res.add(coins[idx]);
                n -= coins[idx];
            }
            if(n == 0) break;
        }
        
        return res.size();
    }
}
