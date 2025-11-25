// Last updated: 25/11/2025, 20:33:46
class Solution {
    Integer[] memo;

    public int numTrees(int n) {
        memo = new Integer[n+1];
        return count(n);
    }

    private int count(int n) {
        // base cases
        if (n <= 1) return 1;

        // memoized
        if (memo[n] != null) return memo[n];

        int total = 0;

        // try every number as root
        for (int root = 1; root <= n; root++) {
            int left = count(root - 1);      // nodes on left
            int right = count(n - root);     // nodes on right
            total += left * right;           // Cartesian product
        }

        return memo[n] = total;
    }
}
