// Lintcode 607
// https://www.lintcode.com/problem/607/

// TC = O(N)
// SC = O(N)

public class TwoSum {
    ArrayList<Integer> data;

    public TwoSum() {
        data = new ArrayList<>();
    }

    public void add(int number) {
        data.add(number);
    }

   
    public boolean find(int value) {
            Collections.sort(data);

            int left = 0;
            int right = data.size() -1;
            while(left < right){
                int sum = data.get(left) + data.get(right);
                if(sum == value) return true;
                else if(sum < value) left++;
                else right--;
            } 
        return false;
    }
}
