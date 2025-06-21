// https://www.geeksforgeeks.org/problems/heap-sort/1

// TC = O(n*logn) in both average and worst case
// SC = O(n)
  
class Solution {
    ArrayList<Integer> data;
    // Function to sort an array using Heap Sort.
    public void downheapify(int idx){
        int l = 2 * idx + 1;
        int r = 2 * idx + 2;
        int min = idx;
        
        if(l < data.size() && data.get(l) < data.get(min)) min = l;
        if(r < data.size() && data.get(r) < data.get(min)) min = r;
        
        if(min == idx) return;
        Collections.swap(data, idx, min);
        downheapify(min);
    }
    
    public int delete(){
        int val  = data.get(0);
        
        Collections.swap(data, 0 , data.size()-1);
        data.remove(data.size()-1);
        downheapify(0);
        return val;
    }
    
    public void heapSort(int arr[]) {
        // code here
        int n = arr.length;
        data = new ArrayList<>();
        for(int val : arr) data.add(val);
        
        for(int idx = n-1; idx >= 0; idx--){
            downheapify(idx);
        }
        
        for(int idx = 0; idx < n; idx++){
            arr[idx] = delete();
        }
    }
    
    
}
