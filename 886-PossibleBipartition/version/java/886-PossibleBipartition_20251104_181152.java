// Last updated: 04/11/2025, 18:11:52
class Solution {

    int[] parent, rank;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        int[] enemy = new int[n + 1]; // enemy[x] = representative of opposite group of x

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            enemy[i] = 0; // initially no enemy assigned
        }

        for (int[] d : dislikes) {
            int a = d[0], b = d[1];

            // If a and b are already in the same set -> impossible
            if (find(a) == find(b)) return false;

            // Assign enemies using union
            if (enemy[a] == 0) enemy[a] = b;
            else union(enemy[a], b);

            if (enemy[b] == 0) enemy[b] = a;
            else union(enemy[b], a);
        }

        return true;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (rank[x] < rank[y]) parent[x] = y;
        else if (rank[x] > rank[y]) parent[y] = x;
        else {
            parent[y] = x;
            rank[x]++;
        }
    }
}
