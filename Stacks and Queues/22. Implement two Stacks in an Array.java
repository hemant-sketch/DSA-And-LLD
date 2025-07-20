// https://www.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1

// TC = O(1)
// SC = O(N)

class twoStacks {
    int[] arr;
    int top1;
    int top2;
    
    twoStacks() {
        arr = new int[100];
        top1 = -1;
        top2 = 100;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        if(top2 == top1 + 1){
            return;
        }else{
            top1++;
            arr[top1] = x;
        }
        
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
         if(top2 == top1 + 1){
            return;
        }else{
            top2--;
            arr[top2] = x;
        }
    }

    // Function to remove an element from top of the stack1.
        
    int pop1() {
        if(top1 == -1) return -1;
        int ans = arr[top1--];
        return ans;
    }

        
    // Function to remove an element from top of the stack2.
    int pop2() {
        if(top2 == 100) return -1;
        int ans = arr[top2++];
        return ans;
    }
}
