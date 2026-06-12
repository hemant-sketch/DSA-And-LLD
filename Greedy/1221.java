class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            count += (c == 'L') ? 1 : -1;

            if (count == 0) {
                ans++;
            }
        }

        return ans;
    }
}
