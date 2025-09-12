// Last updated: 13/09/2025, 01:50:42
class Solution{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count=0;
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
                list.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
      int[] indegree=new int[numCourses];
      for(int i=0;i<list.size();i++){
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
        count++;
        for(int it:list.get(node)){
            indegree[it]--;
            if(indegree[it]==0) q.add(it);
        }

      }
      if(count==numCourses) return true;

      return false;
    }
}