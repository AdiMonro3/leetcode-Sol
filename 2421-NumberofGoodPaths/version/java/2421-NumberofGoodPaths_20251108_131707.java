// Last updated: 08/11/2025, 13:17:07
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind(26);

        // Build equivalence groups
        for (int i = 0; i < s1.length(); i++) {
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Build final string using smallest representative
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int root = uf.find(c - 'a');
            sb.append((char) (root + 'a'));
        }

        return sb.toString();
    }

    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return;

            // Always attach larger letter under smaller letter
            if (pa < pb) parent[pb] = pa;
            else parent[pa] = pb;
        }
    }
}
