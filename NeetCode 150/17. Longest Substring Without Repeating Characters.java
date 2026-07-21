class Solution {
  public int lengthOfLongestSubstring(String s) {
    int ans = 0;
    int[] count = new int[128];

    for (int left = 0, right = 0; right < s.length(); right++) {
      count[s.charAt(right)]++;
      while (count[s.charAt(right)] > 1){
        // left++;
        count[s.charAt(left)]--;
        left++;
      }
      ans = Math.max(ans, right - left + 1);
    }

    return ans;
  }
}

//pwwkewxpw
