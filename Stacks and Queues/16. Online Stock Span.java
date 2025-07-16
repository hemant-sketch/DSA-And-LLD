// Lc 901
// https://leetcode.com/problems/online-stock-span/description/

// TC = O(N)   average O(1)
// SC = O(N)

class StockSpanner { 
    Stack<Integer> stk = new Stack<>();    // remember udhr stack of index bnra tah idhr stack of span bnra hai
    ArrayList<Integer> arr = new ArrayList<>();

    public int next(int price) {
        while(stk.size() > 0 && arr.get(stk.peek()) <= price){
            stk.pop();
        }

        int span = (stk.size() > 0) ? arr.size() - stk.peek() : arr.size() + 1;

        stk.push(arr.size());     // stack mein days aur arr mein prices
        arr.add(price);
        return span;
        
    }
}
