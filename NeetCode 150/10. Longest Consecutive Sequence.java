class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();

        for(int val : nums){
            map.put(val, true);
        }

        for(int val : nums){
            if(map.containsKey(val-1)){
                map.put(val, false);
            }
        }

        int maxLength = 0;

        for(int key : map.keySet()){
            if(map.get(key)){
                int tempLength = 1;

                while(map.containsKey(key + tempLength)){
                    tempLength++;
                }

                maxLength = Math.max(maxLength, tempLength);
            }
        } 

        return maxLength;
    }
}
