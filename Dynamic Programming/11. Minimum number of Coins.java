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

// if you are asked about coins number
// TC O(N)
// SC O(1)
class Solution {
    public int findMin(int n) {
        int[] coins = {1,2,5,10};
        int count = 0;
        
        for(int idx = coins.length-1; idx >= 0; idx--) {
            while(n >= coins[idx]) {
                count++;
                n -= coins[idx];
            }
            if(n == 0) break;
        }
        
        return count;
    }
}

// slightly more better
// TC O(N)
// SC O(1)
class Solution {
    public int findMin(int n) {
        int[] coins = {1,2,5,10};
        int count = 0;
        
        for(int idx = coins.length-1; idx >= 0; idx--) {
            count += n/coins[idx];
            n -= n/coins[idx]*coins[idx];
            
            if(n == 0) break;
        }
        
        return count;
    }
}




