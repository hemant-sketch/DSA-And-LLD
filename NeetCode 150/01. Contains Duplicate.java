// LC 217

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> freq = new HashSet<>();

        for(int val: nums) {
            if(freq.contains(val)) return true;
            freq.add(val);
        }

        return false;
    }
}
