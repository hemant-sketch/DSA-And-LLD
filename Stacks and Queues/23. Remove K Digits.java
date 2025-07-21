// Lc 402
// https://leetcode.com/problems/remove-k-digits/description/

// TC = O(1)
// SC = O(N) because of string builder if we do not consider stringbuilder as extra then O(1)

// eg 2560079489

class Solution {
    public String removeKdigits(String nums, int k) {
        StringBuilder res = new StringBuilder();

        char[] chs = nums.toCharArray();
        for(char ch : chs){
            while(k > 0 && res.length() > 0 && res.charAt(res.length()-1) > ch){
                res.deleteCharAt(res.length()-1);
                k--;
            } 
            res.append(ch);
        }

        while(k-- > 0){
            res.deleteCharAt(res.length()-1);
        }

        int idx = 0;
        while(idx < res.length() && res.charAt(idx) == '0'){
            idx++;
        }
        if(idx == res.length()) return "0";
        return res.toString().substring(idx);
    }
}
