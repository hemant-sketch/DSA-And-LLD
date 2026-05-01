class Solution {
    // 4800 / 25 = 192, so 200 is a safe upper bound for our memoization table.
    private double[][] memo = new double[200][200];

    public double soupServings(int n) {
        /**
         * As n increases, the probability converges to 1.0. 
         * For the constraints of this problem, 4800 is the mathematical "tipping point."
         */
        if (n >= 4800) {
            return 1.0;
        }
        
        // Normalize n into units of 25ml to simplify the recursive steps.
        int units = (n + 24) / 25;
        return dfs(units, units);
    }

    private double dfs(int a, int b) {
        // Base Cases
        if (a <= 0 && b <= 0) return 0.5; // Both empty at the same time
        if (a <= 0) return 1.0;           // A empty first
        if (b <= 0) return 0.0;           // B empty first

        // Return cached result if available
        if (memo[a][b] > 0) {
            return memo[a][b];
        }

        // Recursive step: Calculate 0.25 probability for each of the 4 serving options
        memo[a][b] = 0.25 * (
            dfs(a - 4, b) + 
            dfs(a - 3, b - 1) + 
            dfs(a - 2, b - 2) + 
            dfs(a - 1, b - 3)
        );

        return memo[a][b];
    }
}
