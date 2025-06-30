class Main {
    public class PriorityQueue {
        ArrayList<Integer> data = new ArrayList<>();
    }

    public PriorityQueue() {
        }

    public PriorityQueue(int[] arr) { //agar ek saath poora array aagya       
        // for(int val: data) add(val);  // aise O(N*log N) time lega

        for (int val : arr)                                             // but aise O(N) and per insertion is O(1)
            data.add(val); // Complete Binary Tree
        for (int idx = data.size() - 1; idx >= 0; idx--)
            downheapify(idx); // Heap Order Property
    }
    
    public void add(int val) {   //O(logN)because of upheapify
        data.add(val);
        upheapify(data.size()-1)
    }
    
    void upheapify(int idx) {    //O(logN)
        if(idx = 0) return; //top par hi add hua hai
        
        int par = (idx - 1) / 2;
        if(data.get(par) < data.get(idx)) return;    // idhar > krde agar max heap banana hai
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
    
    public int remove() {      //O(logN) because of downheapify
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
    
    void downheapify(int idx) {    //O(logN)
        int left = 2*left + 1;
        int right = 2*left + 2;
        int min = idx;
        
        if(left < data.size() && data.get(left) < data.get(min)){   // idhar > krde agar max heap banana hai
            min = left;
        }
        if(right < data.size() && data.get(right) < data.get(min)){   // idhar > krde agar max heap banana hai
            min = right;
        }
        
        if(min == idx) return;
        Collections.swap(data, idx, ,min);
        downheapify(min);
    }
} 


