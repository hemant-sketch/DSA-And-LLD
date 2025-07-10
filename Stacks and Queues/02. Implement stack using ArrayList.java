// https://www.geeksforgeeks.org/problems/implement-stack-using-array/1

class MyStack {
    ArrayList<Integer> arr = new ArrayList<>();

    public void push(int x) {
        arr.add(x);
    }

    public int pop() {
        if(arr.size() == 0) return -1;
        return arr.remove(arr.size()-1);
    }
}
