// Lc 134
// https://leetcode.com/problems/gas-station/description/

// TC = O(N^2)
// SC = O(1)
// TLE will give

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int st = 0; st < n; st++){
            int fuel = 0;
            boolean ans = true;

            for(int jump = 0; jump < n; jump++){
                int curr = (st + jump) % n;
                fuel += gas[curr];

                if(fuel < cost[curr]){
                    ans = false;
                    break;
                }
                fuel -= cost[curr];
            }  
            if(ans == true) return st;
        }
        return -1;
    }
}

// TC = O(N)
// SC = O(N)
// optimised 

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



// best approach
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;

        for (int idx = 0; idx < gas.length; idx++) {
            totalGas += gas[idx];
            totalCost += cost[idx];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int currentGas = 0, startIndex = 0;

        for (int idx = 0; idx < gas.length; idx++) {
            currentGas += gas[idx] - cost[idx];

            if (currentGas < 0) {
                startIndex = idx + 1;
                currentGas = 0;
            }
        }

        return startIndex;
    }
}
