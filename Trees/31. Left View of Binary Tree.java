// https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
// O(n)

class Solution {
	public ArrayList<Integer> leftView(Node root) {
		ArrayList<Integer> left = new ArrayList<>();
		if(root == null) return left;
		Queue<Node> q = new ArrayDeque<>();
		
		q.add(root);
		
		while (!q.isEmpty()) {
			left.add(q.peek().data);
			int size = q.size();
			
			for (int idx = 0; idx < size; idx++) {
				Node src = q.poll();
				if (src.left != null)
					q.add(src.left);
				if (src.right != null)
					q.add(src.right);
			}
		}
		
		return left;
	}
}
