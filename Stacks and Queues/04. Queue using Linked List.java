// https://www.geeksforgeeks.org/problems/implement-queue-using-linked-list/1

class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}

class MyQueue
{
    QueueNode front, rear;
    
    
	void push(int a)  //O(1)
	{
        QueueNode node  = new QueueNode(a);    //insert at tail krre
        
        if(front == null){
            front = rear = node;
        }else{
            rear.next = node;
            rear = node;
        }
	}
	
    
	int pop()
	{
	    if(front == null) return -1;
        int ans = front.data;
        front = front.next;
        return ans;
	}
}
