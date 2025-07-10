// Lc 622
// https://leetcode.com/problems/design-circular-queue/

class MyCircularQueue {
    int[] arr;
    int size = 0, front = 0, rear = 0;

    public MyCircularQueue(int k) {
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {  // O(1)
        if(isFull()) return false;

        arr[rear] = value;
        size++;
        rear = (rear + 1) % arr.length;
        return true;
    }
    
    public boolean deQueue() {    // O(1)
        if(isEmpty()) return false;

        front = (front + 1) % arr.length;
        size--;
        return true;
    }
    
    public int Front() {    // O(1)
        if(isEmpty()) return -1; 
        return arr[front];
    }
    
    public int Rear() {    // O(1)
        if(isEmpty()) return -1;
        
        return arr[(rear - 1 + arr.length)% arr.length];
    }
    
    public boolean isEmpty() {   // O(1)
        return (size == 0);
    }
    
    public boolean isFull() {   // O(1)
        return (size == arr.length);
    }
}
