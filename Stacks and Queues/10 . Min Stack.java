// Lc 155
// https://leetcode.com/problems/min-stack/description/

// TC = O(1)
// SC = O(N)
class MinStack {
    Stack<Integer> stk;
    Stack<Integer> minStk;

    public MinStack() {
        stk = new Stack<>();
        minStk = new Stack<>();
        minStk.add(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        stk.add(val);
        int newMin = Math.min(val, minStk.peek());
        minStk.add(newMin);
    }
    
    public void pop() {
        stk.pop();
        minStk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }
}

// optimised   // encryp val = 2*val - min       // min = 2*min - top
// TC = O(1)
// SC = O(1)
class MinStack {
    Stack<Long> stk = new Stack<>();
    long min = Integer.MAX_VALUE;
    
    public void push(int val) {
        if(val >= min){
            stk.push(1l * val);
        }else{
            stk.push(2l * val - min);
            min = val;
        }
    }
    
    public void pop() {
        long top = stk.pop();
        if(top >= min) return;
        min = 2l * min - top;
    }
    
    public int top() {
        long top = stk.peek();
        if(top < min){
            return (int)min;
        }
        return (int)top;
    }
    
    public int getMin() {
        return (int)min;
    }
}
                                         
