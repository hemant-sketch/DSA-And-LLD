class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int n = words.length; // Use the length of the input array
        int groupId = -1;

        for (int i = 0; i < n; ++i) {
            if (groups[i] != groupId) {
                groupId = groups[i];
                ans.add(words[i]);
            }
        }

        return ans;
    }
}
