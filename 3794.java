class Solution {
    public String reversePrefix(String s, int k) {
        if(s.length() == 1) return s;
        StringBuilder ans = new StringBuilder();

        for(int idx = k-1; idx >= 0; idx--) {
            ans.append(s.charAt(idx));
        }

        for(int idx = k; idx < s.length(); idx++) {
            ans.append(s.charAt(idx));
        }

        return ans.toString();
    }
}
