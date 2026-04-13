// Last updated: 13/04/2026, 15:52:34
  class Solution {
    int t, k;
    int[] seen;
    StringBuilder sb = new StringBuilder();

    public String crackSafe(int n, int k) {
      this.k = k;
      t = (int) Math.pow(k, n - 1);
      seen = new int[t];
      dfs(0);
      sb.append("0".repeat(n - 1));
      return sb.reverse().toString();
    }

    void dfs(int u) {
      while (seen[u] < k) {
        int d = seen[u]++;
        dfs((u * k + d) % t);
        sb.append((char) ('0' + d));
      }
    }
  }