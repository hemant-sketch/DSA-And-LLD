// Lc 678
// https://leetcode.com/problems/valid-parenthesis-string/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int deficit = 0, fuel = 0, start = 0;

        for(int idx = 0; idx < gas.length; idx++){
            fuel += gas[idx] - cost[idx];

            if(fuel < 0){
                start = idx + 1;
                deficit += -fuel;
                fuel = 0;
            }
        }

        if(fuel >= deficit) return start;
        return -1;
    }
}
