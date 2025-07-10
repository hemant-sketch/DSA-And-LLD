// Lc 387
// https://leetcode.com/problems/first-unique-character-in-a-string/description/

// brute force
// TC = O(N*N)
// SC = O(1)

class Solution {
    public int firstUniqChar(String s) {
        for(int first = 0; first < s.length(); first++){
            boolean unique = true;
            for(int second = 0; second < s.length(); second++){
                if(first != second && s.charAt(first) == s.charAt(second)){
                    unique = false;
                    break;
                }
            }
            if(unique == true) return first;
        }
        return -1;
    }
}

// optimum using hashing
// TC = O(N)
// SC = O(N)

class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(int idx = 0; idx < s.length(); idx++){
            int index = s.charAt(idx) - 'a';
            freq[index]++;
        }

        for(int idx = 0; idx < s.length(); idx++){
            int index = s.charAt(idx) - 'a';
            if(freq[index] == 1){
                return idx;
            }
        }

        return -1;
    }
}

