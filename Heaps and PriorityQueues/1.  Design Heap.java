import java.util.ArrayList;
import java.util.Collections;

class Main {

    public static class PriorityQueue {
        ArrayList<Integer> data = new ArrayList<>();

        public PriorityQueue() {
        }

        public PriorityQueue(int[] arr) {
            for (int val : arr) {
                data.add(val);
            }
            // Start from the first non-leaf node and heapify upwards
            for (int i = (data.size() / 2) - 1; i >= 0; i--) {
                downheapify(i);
            }
        }
        
        public int size() { //1
            return this.data.size();
        }

        public boolean isEmpty() {
            return this.data.isEmpty();
        }

        public void add(int val) { //logn
            data.add(val);
            upheapify(data.size() - 1);
        }

        private void upheapify(int idx) { //logn
            if (idx == 0) {
                return;
            }

            int par = (idx - 1) / 2;
            if (data.get(par) > data.get(idx)) {
                Collections.swap(data, par, idx);
                upheapify(par);
            }
        }

        public int peek() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int remove() { //logn
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            
            Collections.swap(data, 0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }

        private void downheapify(int idx) {  //logn
            int min = idx;
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;

            if (left < data.size() && data.get(left) < data.get(min)) {
                min = left;
            }

            if (right < data.size() && data.get(right) < data.get(min)) {
                min = right;
            }
            
            if (min != idx) {
                Collections.swap(data, idx, min);
                downheapify(min);
            }
        }
    }
}
