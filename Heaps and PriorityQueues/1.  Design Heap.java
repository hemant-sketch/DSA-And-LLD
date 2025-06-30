class Main {
    public class PriorityQueue {
        ArrayList<Integer> data = new ArrayList<>();
    }
    
    public void add(int val) {   //O(logn) because of upheapify
        data.add(val);
        upheapify(data.size()-1)
    }
    
    void upheapify(int idx) {    //O(logn)
        if(idx = 0) return; //top par hi add hua hai
        
        int par = (idx - 1) / 2;
        if(data.get(par) < data.get(idx)) return;
        Collections.swap(data, par, idx);
        upheapify(par);
    }
    
    public int peek() {   //O(1)
        if(data.size() == 0){
            System.out.println("Undeflow");
            return -1
        }
        return data.get(0);
    }
    
    public int size() {   ////O(1)
            return data.size();
    }
    
    public int remove() {      //O(logn) because of downheapify
        if(data.size() == 0){
            System.out.println("Underflow");
            return -1;
        }
        
        int val = data.get(0);
        Collections.swap(data, val, data.size()-1);
        data.remove(data.size()-1);
        downheapify(0);
        return val;
    }
    
    void downheapify(int idx) {    //O(logn)
        int left = 2*left + 1;
        int right = 2*left + 2;
        int min = idx;
        
        if(left < data.size() && data.get(left) < data.get(min)){
            min = left;
        }
        if(right < data.size() && data.get(right) < data.get(min)){
            min = right;
        }
        
        if(min == idx) return;
        Collections.swap(data, idx, ,min);
        downheapify(min);
    }
} 
