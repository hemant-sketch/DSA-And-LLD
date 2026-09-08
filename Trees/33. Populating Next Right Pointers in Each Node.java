// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/

// TC O(n) && SC O(n)  queue ka lagega n space 
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            for(int count = q.size(); count > 0; count--) {
                Node curr = q.poll();
                if(count > 1) curr.next = q.peek();
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }

        return root;
    }
}

// constant space
// TC O(n) && SC O(1)
class Solution {
    public Node connect(Node root) {
        Node curr = root;

        while (curr != null) {
            Node head = new Node(-1);
            Node tail = head;

            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }

                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }

                curr = curr.next;
            }

            curr = head.next;
        }

        return root;
    }
}
