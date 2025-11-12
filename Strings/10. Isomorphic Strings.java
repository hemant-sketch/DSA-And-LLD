// Lc 205
// https://leetcode.com/problems/isomorphic-strings/description/

// Tc = O(N) length of the input string
// Sc = O(256)

class Solution {
    public boolean check (String s, String t) {
        int[] map = new int[256];

        for(int idx = 0; idx < s.length(); idx++) {
            int char1 = s.charAt(idx);  //achaa idhr hum 97  idx par hi value dalre kuiki size of array very big taekn already
            int char2 = t.charAt(idx); //so no need to do    -'a'

            if(map[char1] != '\u0000' && map[char1] != char2) return false;
            map[char1] = char2; 
        }

        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        return check(s, t) && check(t, s);  //foo bar and bar foo
    }
}
