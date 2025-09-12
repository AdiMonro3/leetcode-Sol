// Last updated: 13/09/2025, 01:48:00
class Solution {
    private int time = 0;
    public void dfs(int node,int parent,int[] disc,int[] low,ArrayList<ArrayList<Integer>> adj,boolean[] visited,List<List<Integer>> ans){
        visited[node]=true;
        disc[node] = low[node] = time++;
        for(int i=0;i<adj.get(node).size();i++){
            int nebr=adj.get(node).get(i);
            if(nebr==parent) continue;
            else if(visited[nebr]){
                low[node]=Math.min(low[node],low[nebr]);
            }
            else{
                dfs(nebr,node,disc,low,adj,visited,ans);
                low[node] = Math.min(low[node], low[nebr]);
                if(low[nebr]>disc[node]){
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(node);
                    temp.add(nebr);
                    ans.add(temp);
                }
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<connections.size();i++){
           int from=connections.get(i).get(0);
           int to=connections.get(i).get(1);
           adj.get(from).add(to);
           adj.get(to).add(from);
        }
        List<List<Integer>> ans=new ArrayList<>();
        int [] disc=new int[n];
        int [] low=new int [n];
        boolean[] visited=new boolean[n];
        dfs(0,-1,disc,low,adj,visited,ans);
        return ans;

    }
}