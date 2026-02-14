// Last updated: 14/02/2026, 10:45:00
1class Solution {
2    class Pair{
3        int val;
4        int wt;
5
6        Pair(int val,int wt){
7            this.val=val;
8            this.wt=wt;
9        }
10    }
11    public int mst(List<List<Pair>> adj,int n){
12        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.wt-b.wt);
13        boolean visited[]=new boolean[n];
14
15        int ans=0;
16        pq.add(new Pair(0,0));
17        while(!pq.isEmpty()){
18            Pair temp=pq.poll();
19            if(visited[temp.val]) continue;
20
21            visited[temp.val]=true;
22            ans+=temp.wt;
23
24            for(Pair curr:adj.get(temp.val)){
25                if(!visited[curr.val]){
26                    pq.offer(new Pair(curr.val,curr.wt));
27                }
28            }
29        }
30        return ans;
31    }
32    public int minCostConnectPoints(int[][] points) {
33        int n=points.length;
34        List<List<Pair>> adj=new ArrayList<>();
35
36        for(int i=0;i<points.length;i++){
37            adj.add(new ArrayList<>());
38        }
39        for(int i=0;i<n;i++){
40            for(int j=i+1;j<n;j++){
41                int x1=points[i][0];
42                int y1=points[i][1];
43
44                int x2=points[j][0];
45                int y2=points[j][1];
46
47                int d=Math.abs(x1-x2)+Math.abs(y1-y2);
48
49                adj.get(i).add(new Pair(j,d));
50                adj.get(j).add(new Pair(i,d));
51            }
52        }
53        return mst(adj ,n);
54    }
55}