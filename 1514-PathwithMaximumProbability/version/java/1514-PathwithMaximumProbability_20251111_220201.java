// Last updated: 11/11/2025, 22:02:01
class Solution {
    class Pair{
        int node;
        double prob;
        public Pair(int node,double prob){
            this.node=node;
            this.prob=prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
         List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }


        double result[]=new double[n];

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> Double.compare(b.prob,a.prob));

        result[start_node]=1.0;
        pq.add(new Pair(start_node,1.0));

        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int node=temp.node;
            double prob=temp.prob;

            if (node == end_node) return prob;

            // Explore neighbors
            for (Pair nei : adj.get(node)) {
                int next = nei.node;
                double newProb = prob * nei.prob;

                // Relaxation step
                if (newProb > result[next]) {
                    result[next] = newProb;
                    pq.add(new Pair(next, newProb));
                }
            }
        }

        return 0.0;
    }
}