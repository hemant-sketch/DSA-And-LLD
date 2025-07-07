// https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

// TC = O(N)
// SC = O(N)

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        for(int idx = 0; idx < k; idx++){
            if(arr[idx] < 0){
                q.add(idx);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        res.add((q.size() == 0) ? 0 : arr[q.peek()]);
        
        for(int idx = k; idx < n; idx++){
            if(q.size() > 0 && q.peek() <= idx - k){
                q.remove();
            }
            
            if(arr[idx] < 0){
                q.add(idx);
            }
            
            res.add((q.size() == 0) ? 0 : arr[q.peek()]);
        }
        return res;
        
    }
}
