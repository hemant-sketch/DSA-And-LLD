// Lc 641
// https://leetcode.com/problems/design-circular-deque/description/

class MyCircularDeque {
    int[] arr;
    int size = 0;
    int rear = 0;
    int front = 0;

    public MyCircularDeque(int k) {
        arr = new int[k];
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;

        front = (front - 1 + arr.length) % arr.length;
        arr[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size == arr.length) return false;

        arr[rear] = value;
        rear = (rear + 1) % arr.length;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size == 0) return false;

        front = (front + 1) % arr.length;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;

        rear = (rear - 1 + arr.length) % arr.length;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return arr[(rear - 1 + arr.length)% arr.length];
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public boolean isFull() {
        return (size == arr.length);
    }
}
