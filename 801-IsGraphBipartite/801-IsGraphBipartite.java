// Last updated: 13/09/2025, 01:48:37
class Solution {
     private boolean dfs(int node, int col, int color[], int [][] graph) {
        
        color[node] = col; 
        
        // traverse adjacent nodes
        for(int it : graph[node]) {
            // if uncoloured
            if(color[it] == -1) {
                if(dfs(it, 1 - col, color, graph) == false) return false; 
            }
            // if previously coloured and have the same colour
            else if(color[it] == col) {
                return false; 
            }
        }
        
        return true; 
    }
    public boolean isBipartite(int[][] graph) {
         int color[] = new int[graph.length];
	    for(int i = 0;i<graph.length;i++) color[i] = -1; 
	    
	    // for connected components
	    for(int i = 0;i<graph.length;i++) {
	        if(color[i] == -1) {
	            if(dfs(i, 0, color, graph) == false) return false; 
	        }
	    }
	    return true; 
    }
}