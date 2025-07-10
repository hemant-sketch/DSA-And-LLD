// https://www.geeksforgeeks.org/problems/implement-stack-using-linked-list/1

class MyStack {
    class StackNode {
        int data;
        StackNode next;
        StackNode(int a) {
            data = a;
            next = null;
        }
    }
    StackNode head = null;
    
    void push(int a) {
        StackNode Node = new StackNode(a);
        Node.next = head;
        head = Node;
    }

    int pop() {
        if(head == null) return -1;
        int ans = head.data;
        head = head.next;
        return ans;
    }
}
