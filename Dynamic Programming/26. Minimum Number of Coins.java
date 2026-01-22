// https://www.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1

// TC O(n*4)
// SC O(n)

class Solution {
    public int findMin(int n) {
        int[] coins = {1,2,5,10};
        int count = 0;
        
        for(int idx = coins.length-1; idx >= 0; idx--) {
            // while(n >= coins[idx]) {
            //     count++;
            //     n -= coins[idx];
            // }
            count += n/coins[idx];
            n -= n/coins[idx]*coins[idx];
            
            if(n == 0) break;
        }
        
        return count;
    }
}

// if they ask for array
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
