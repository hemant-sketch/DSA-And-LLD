// Lc 232
// https://leetcode.com/problems/implement-queue-using-stacks/description/

// push easy pop heavy
class MyQueue {
    Stack<Integer> actual = new Stack<>();
    Stack<Integer> extra = new Stack<>();
    
    public void push(int x) {
        actual.push(x);
    }
    
    public int pop() {
        while(actual.size() > 0){
            extra.push(actual.pop());
        }
        int ans = extra.pop();
        while(extra.size() > 0){
            actual.push(extra.pop());
        }
        return ans;
    }
    
    public int peek() {
        while(actual.size() > 0){
            extra.push(actual.pop());
        }
        int ans = extra.peek();
        while(extra.size() > 0){
            actual.push(extra.pop());
        }
        return ans;
    }
    
    public boolean empty() {
        return actual.size() == 0;
    }
}

// push heavy pop easy
class MyQueue {
    Stack<Integer> actual = new Stack<>();
    Stack<Integer> extra = new Stack<>();

    public void push(int x) {
        while(actual.size() > 0){
            extra.push(actual.pop());
        }
        actual.push(x);
        while(extra.size() > 0){
            actual.push(extra.pop());
        }
    }
    
    public int pop() {
        return actual.pop();
    }
    
    public int peek() {
        return actual.peek(); 
    }
    
    public boolean empty() {
        return actual.size() == 0;
    }
}
