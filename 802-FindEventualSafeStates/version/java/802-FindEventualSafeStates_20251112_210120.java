// Last updated: 12/11/2025, 21:01:20
class Solution {
    // Helper function for Kahn's Algorithm (Topological Sort)
    private List<Integer> topoSort(List<List<Integer>> graph, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);
            for (int nbr : graph.get(node)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) q.offer(nbr);
            }
        }

        return order.size() == graph.size() ? order : new ArrayList<>();
    }
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> itemgraph=new ArrayList<>();
        List<List<Integer>> groupGraph=new ArrayList<>();
        for(int i=0;i<group.length;i++){
            if(group[i]==-1){
                group[i]=m;
                m++;
            }
        }
        for(int i=0;i<n;i++) itemgraph.add(new ArrayList<>());
        for(int i=0;i<m;i++) groupGraph.add(new ArrayList<>());

        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[m];

        // Build dependency graphs
        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {
                itemgraph.get(prev).add(i);
                itemIndegree[i]++;

                // If items belong to different groups, link their groups
                if (group[prev] != group[i]) {
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }
        // Step 3: Perform topological sort on groups and items
        List<Integer> groupOrder = topoSort(groupGraph, groupIndegree);
        if (groupOrder.isEmpty()) return new int[0]; // cycle detected

        List<Integer> itemOrder = topoSort(itemgraph, itemIndegree);
        if (itemOrder.isEmpty()) return new int[0]; // cycle detected


        // Step 4: Collect items by group in order
        Map<Integer, List<Integer>> groupedItems = new HashMap<>();
        for (int item : itemOrder) {
            groupedItems.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

         // Step 5: Merge items according to group order
        List<Integer> resultList = new ArrayList<>();
        for (int g : groupOrder) {
            if (groupedItems.containsKey(g)) {
                resultList.addAll(groupedItems.get(g));
            }
        }

        // Step 6: Convert result list to array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) result[i] = resultList.get(i);
        return result;

    }
}