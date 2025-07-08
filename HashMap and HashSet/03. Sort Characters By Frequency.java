// Lc 451
// https://leetcode.com/problems/sort-characters-by-frequency/description/

// TC = O(N)
// SC = O(N+26)

class Solution {
    public String frequencySort(String s) {
        HashMap<Character , Integer> freq =  new HashMap<>();
        for(int idx =  0; idx < s.length(); idx++){
            char ch  = s.charAt(idx);
            freq.put(ch, freq.getOrDefault(ch , 0) + 1);
        } 

        HashMap<Integer, ArrayList<Character>> rev = new HashMap<>();
        for(Character ch : freq.keySet()){
            int f = freq.get(ch);
            if(rev.containsKey(f) ==  false){
                rev.put(f, new ArrayList<>());
            }
            rev.get(f).add(ch);
        }

        StringBuilder res = new StringBuilder("");
        for(int f = s.length(); f >= 1; f--){
            if(rev.containsKey(f) == true){
                for(Character ch : rev.get(f)){
                    for(int idx = 1; idx <= f; idx++){
                        res.append(ch);
                    }
                }
            }
        }

        return res.toString();

    }
}
