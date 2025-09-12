// Last updated: 13/09/2025, 01:48:35
class Solution {
    class Pair {
        int to;
        int cost;
        Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    class Node {
        int city;
        int cost;
        int steps;
        Node(int city, int cost, int steps) {
            this.city = city;
            this.cost = cost;
            this.steps = steps;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        // cost to reach [city][steps]
        int[][] dist = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Node(src, 0, 0));
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int city = cur.city, cost = cur.cost, steps = cur.steps;

            if (city == dst) return cost;
            if (steps > k) continue;

            for (Pair nei : graph.get(city)) {
                int nextCity = nei.to;
                int nextCost = cost + nei.cost;

                if (nextCost < dist[nextCity][steps + 1]) {
                    dist[nextCity][steps + 1] = nextCost;
                    pq.add(new Node(nextCity, nextCost, steps + 1));
                }
            }
        }

        return -1;
    }
}