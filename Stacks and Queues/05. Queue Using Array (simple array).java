// https://www.geeksforgeeks.org/problems/implement-queue-using-array/1

class MyQueue {

    int front, rear;
    int arr[] = new int[100005];

    MyQueue() {
        front = 0;
        rear = 0;
    }

    int size = 0;
    void push(int x) {
        if(size == arr.length) return;
        arr[rear] = x;
        rear++;
        size++;
    }

    int pop() {
        if(size == 0) return -1;
        int ans = arr[front];
        front++;
        size--;
        return ans;
    }
}
