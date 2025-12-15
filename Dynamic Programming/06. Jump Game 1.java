.dp gives tle here



. best done using greedy ex for false 2,4,3,1,1,0,4,2
class Solution {
    public boolean canJump(int[] jumps) {
        int reach = 0;
        for(int idx = 0; idx <  jumps.length; idx++) {
            if(idx > reach) return false;

            if(jumps[idx] + idx > reach) {
                reach = jumps[idx] + idx;
            } 
        }
        return true;
    }
}
