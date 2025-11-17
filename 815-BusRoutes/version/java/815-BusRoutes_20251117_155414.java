// Last updated: 17/11/2025, 15:54:14
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source ==target) return 0;
        HashMap<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){

                map.computeIfAbsent(routes[i][j],k->new ArrayList<>()).add(i);
            }
        }
        boolean visited[]=new boolean[routes.length];
        Queue<Integer> q=new LinkedList<>();
        for(int temp: map.getOrDefault(source, Collections.emptyList())){
            q.add(temp);
            visited[temp]=true;
        }
        int ans=1;
        while(!q.isEmpty()){
            
            int size=q.size();

            for(int k=0;k<size;k++){
            int temp=q.poll();
            

                for(int i=0;i<routes[temp].length;i++){
                    if(routes[temp][i]==target) return ans;

                    for(int x:map.getOrDefault(routes[temp][i], Collections.emptyList())){
                        if(!visited[x]){
                            q.add(x);
                            visited[x]=true;
                        }
                    }
                }
            }
            ans++;
        }
       
        return -1;

    }
}