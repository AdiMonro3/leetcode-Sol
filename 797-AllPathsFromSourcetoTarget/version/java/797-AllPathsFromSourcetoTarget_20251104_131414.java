// Last updated: 04/11/2025, 13:14:14
class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public void dfs(int [][] graph,int node,int target){
        if(node==target){
            ans.add(new ArrayList(path));
            return;
        }

        for(int v:graph[node]){
            path.add(v);
            dfs(graph,v,target);
            path.remove(path.size() - 1);
        }

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target=graph.length-1;
        path.add(0);
        dfs(graph,0,target);

        return ans;
    }
}