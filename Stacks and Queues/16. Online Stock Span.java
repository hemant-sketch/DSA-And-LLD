// Lc 901
// https://leetcode.com/problems/online-stock-span/description/

// TC = O(N)
// SC = O(N)

class StockSpanner {
    Stack<Integer> stk = new Stack<>();
    ArrayList<Integer> arr = new ArrayList<>();

    public int next(int price) {
        while(stk.size() > 0 && arr.get(stk.peek()) <= price){
            stk.pop();
        }

        int span = (stk.size() > 0) ? arr.size() - stk.peek() : arr.size() + 1;

        stk.push(arr.size());
        arr.add(price);
        return span;
        
    }
}
