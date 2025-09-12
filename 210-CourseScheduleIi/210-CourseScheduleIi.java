// Last updated: 13/09/2025, 01:50:41
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        int topo[]=new int [numCourses];
        int j=0;
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int from=prerequisites[i][1];
            int to=prerequisites[i][0];
            list.get(from).add(to);
        }
        int indegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:list.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            topo[j]=node;
            j++;
            for(int it:list.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if (j != numCourses) return new int[0];
        return topo;
    }
}