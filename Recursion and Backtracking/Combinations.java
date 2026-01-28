// Aproach 1
class Solution {
    List<List<Integer>> ways;

    public void printPaths(int n, int k, List<Integer> output) {
        if(k == 0) {
            ways.add(new ArrayList<>(output));
            return;
        }
        if(n == 0 || k > n) return;

        output.add(n); //yeah
        printPaths(n-1, k-1, output);
        output.remove(output.size()-1); //backtrack

        printPaths(n-1, k, output); //nahh
    }

    public List<List<Integer>> combine(int n, int k) {
        ways = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        printPaths(n, k, output);
        return ways;
    }
}
