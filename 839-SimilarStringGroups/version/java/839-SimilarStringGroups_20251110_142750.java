// Last updated: 10/11/2025, 14:27:50
class Solution {
    public void dfs( List<List<Integer>> adj,int node,int parent,int[] visited){
        visited[node]=1;
        for(int i:adj.get(node)){
            if(visited[i]==0 && i!=parent){
                dfs(adj,i,node,visited);
            }
        }
    }
    public boolean isSimilar(String s1,String s2){
        int n=s1.length();
        int diff=0;
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
            }
        }
        if(diff<=2) return true;

        return false;
    }
    public int numSimilarGroups(String[] strs) {
        int n=strs.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilar(strs[i],strs[j])){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int visited[]=new int [n];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(adj,i,-1,visited);
                count++;
            }
        }
        
        return count;
    }
}