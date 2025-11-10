// Last updated: 10/11/2025, 23:31:33
class Solution {
     static class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
    public void dfs(Map<String, List<Pair>> adj, String src, String dst,
                    Set<String> visited, double product, double[] ans) {
        // If already visited, return
        if (visited.contains(src)) return;

        // Mark node as visited
        visited.add(src);

        // Found destination
        if (src.equals(dst)) {
            ans[0] = product;
            return;
        }

        // Explore neighbors
        for (Pair p : adj.getOrDefault(src, new ArrayList<>())) {
            dfs(adj, p.node, dst, visited, product * p.value, ans);
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,List<Pair>> adj=new HashMap<>();
        int n=values.length;

        for(int i=0;i<n;i++){
            String u=equations.get(i).get(0);
            String v=equations.get(i).get(1);
            double val=values[i];

            
            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(new Pair(v, val));
            adj.computeIfAbsent(v, x -> new ArrayList<>()).add(new Pair(u, 1.0 / val));
        }

            double[] result = new double[queries.size()];

          for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            double[] ans = {-1.0}; // use array to pass by reference
            double product = 1.0;

            if (adj.containsKey(src)) {
                Set<String> visited = new HashSet<>();
                dfs(adj, src, dst, visited, product, ans);
            }

            result[i] = ans[0];
        }

        return result;

        }
    }
