// https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1

// TC = O(N)
// SC = O(N)

// left to right
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int[] nge = new int[arr.length];
        Arrays.fill(nge, -1);
        
        for(int idx = 0; idx < arr.length; idx++){
            while(stk.size() > 0 && arr[stk.peek()] < arr[idx]){
                nge[stk.pop()] = arr[idx];
            }
            
            stk.push(idx);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int idx = 0 ; idx < arr.length; idx++){
            res.add(nge[idx]);
        }
        
        return res;
    }
}

// right to left
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int[] nge = new int[arr.length];
        
        for(int idx = arr.length-1; idx >= 0; idx--){
            while(stk.size() > 0 && arr[stk.peek()] <= arr[idx]){
                stk.pop();
            }
            nge[idx] = (stk.size() > 0) ? arr[stk.peek()] : -1;
            stk.push(idx);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int idx = 0 ; idx < arr.length; idx++){
            res.add(nge[idx]);
        }
        
        return res;
    }
}
