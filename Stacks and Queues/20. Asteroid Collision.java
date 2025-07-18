// Lc 735
// https://leetcode.com/problems/asteroid-collision/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> stk = new ArrayList<>();

        for(int idx = 0; idx < asteroids.length; idx++){
            int right = asteroids[idx];

            if(right > 0) stk.add(right);
            else if(stk.size() == 0 || stk.get(stk.size()-1) < 0){
                stk.add(right);
            }
            else if(stk.get(stk.size()-1) < -right){
                stk.remove(stk.size()-1);
                idx--;
            }
            else if(stk.get(stk.size()-1) == -right){
                stk.remove(stk.size()-1);
            }
        } 
        int[] ans = new int[stk.size()];
        for(int idx = 0; idx < ans.length; idx++){
            ans[idx] = stk.get(idx);
        }
        return ans;
    }
}

        //  int[] ans = new int[stk.size()];
        // for(int idx = 0; idx < stk.size(); idx++){   yeh galat kiuki size har bar change hora
        //     ans[idx] = stk.remove(idx);   aur yeh galat kiuki remove krne par 0 par new value aari har baari
        // }
