// https://www.geeksforgeeks.org/problems/implement-stack-using-array/1

class MyStack {
    int[] arr = new int[1000];
    int top = 0;

    public void push(int x) {  // O(N)
        if(x == arr.length) return;
        arr[top] = x;
        top++;
    }

    public int pop() {   //O(N)
        if(top == 0) return -1;
        top--;
        return arr[top];
    }
}
