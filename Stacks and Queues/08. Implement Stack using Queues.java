// Lc 225
// https://leetcode.com/problems/implement-stack-using-queues/description/

// approach 1 : push efficeint , pop heavy
class MyStack {
    Queue<Integer> q = new ArrayDeque<>();
    
    public void push(int x) {  //O(1)
        q.add(x);
    }
    
    public int pop() {   //O(N)
        for(int idx = 0; idx < q.size()-1; idx++){  //n-1 tak chalaya
            q.add(q.remove());
        }
        return q.remove();
    }
    
    public int top() {  //O(N)
        for(int idx = 0; idx < q.size()-1; idx++){
            q.add(q.remove());
        }
        int ans = q.remove();
        q.add(ans);
        return ans;
    }
    
    public boolean empty() {   //O(1)
        return q.size() == 0;
    }
}

// approach 2 : push heavy : pop efficient
class MyStack {
    Queue<Integer> q = new ArrayDeque<>();
    
    public void push(int x) { // O(N)
        q.add(x);
        for(int idx = 0; idx < q.size()-1; idx++){
            q.add(q.remove());
        }
    }
    
    public int pop() {   // O(1)
        return q.remove();
    }
    
    public int top() {   // O(1)
        return q.peek();
    }
    
    public boolean empty() {    // O(1)
        return q.size() == 0;
    }
}
