// Last updated: 05/11/2025, 14:02:58
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();//no. of nodes

        int visited[]= new int[n];// visited array 

        Queue<Integer> q=new ArrayDeque<>();
        int count=0;
        q.add(0);
        visited[0]=1;

        while(!q.isEmpty()){
            int node=q.poll();
            count++;

            List<Integer> temp=rooms.get(node);

            for(int i:temp){
                if(visited[i]==1) continue;
                q.add(i);
                visited[i]=1;
            }
        }
        if(count==n) return true;

        return false;
    }
}