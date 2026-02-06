// Last updated: 06/02/2026, 15:44:16
1class Solution {
2    public void dfs( Map<String,PriorityQueue<String>> graph,List<String> itenary,String s){
3        
4        PriorityQueue<String> pq = graph.get(s);
5        while(pq != null && !pq.isEmpty()){
6            String t=pq.poll();
7            dfs(graph,itenary,t);
8        }
9        itenary.add(s);
10    }
11    public List<String> findItinerary(List<List<String>> tickets) {
12        Map<String,PriorityQueue<String>> map=new HashMap<>();
13
14        for(List<String> lst:tickets){
15            String from=lst.get(0);
16            String to=lst.get(1);
17
18            map.putIfAbsent(from,new PriorityQueue<>());
19            map.get(from).offer(to);
20        }
21        List<String> itenary=new ArrayList<>();
22        dfs(map,itenary,"JFK");
23        Collections.reverse(itenary);
24        return itenary;
25    }
26}