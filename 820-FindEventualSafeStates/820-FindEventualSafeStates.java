// Last updated: 13/09/2025, 01:48:31
class Solution {
    public boolean dfs(int [][]graph,int u,boolean[]visited,boolean [] pathvisited,int []check){
        visited[u]=true;
        pathvisited[u]=true;
        for(int i:graph[u]){
            if(!visited[i]){
             if(dfs(graph,i,visited,pathvisited,check)) return true;
            }
            else if(visited[i] && pathvisited[i]) return true;
        }
        check[u]=1;
        pathvisited[u]=false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean []visited=new boolean[n];
        boolean []pathvisited=new boolean[n];
        int check[]=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]!=true){
                dfs(graph,i,visited,pathvisited,check);
            }
        }
        ArrayList<Integer> safe=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1) safe.add(i);
        }
        return safe;
    }
}