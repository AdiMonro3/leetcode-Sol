// Last updated: 17/11/2025, 16:00:21
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        int n = routes.length;

        // Map each stop -> list of bus route indices that pass this stop
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        // BFS Initialization
        Queue<Integer> queue = new LinkedList<>();  // bus routes
        boolean[] visitedBus = new boolean[n];
        Set<Integer> visitedStops = new HashSet<>();

        // Start with all buses available at source
        if (!stopToBuses.containsKey(source)) return -1;
        for (int bus : stopToBuses.get(source)) {
            queue.offer(bus);
            visitedBus[bus] = true;
        }

        int busesTaken = 1;  // first hop = taking 1 bus

        // BFS over bus routes
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int bus = queue.poll();

                for (int stop : routes[bus]) {
                    if (stop == target) return busesTaken;

                    if (!visitedStops.add(stop)) continue;

                    for (int nextBus : stopToBuses.get(stop)) {
                        if (!visitedBus[nextBus]) {
                            visitedBus[nextBus] = true;
                            queue.offer(nextBus);
                        }
                    }
                }
            }

            busesTaken++;
        }

        return -1;
    }
}
