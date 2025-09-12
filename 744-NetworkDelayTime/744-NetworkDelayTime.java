// Last updated: 13/09/2025, 01:48:44
class Solution {
    class Pair{
        int node;
        int time;
        Pair(int node,int time){
            this.node=node;
            this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> list=new  ArrayList<>();
        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int from=times[i][0];
            int to=times[i][1];
            int timet=times[i][2];
            list.get(from).add(new Pair(to,timet));
        }
        int timetaken[]=new int [n+1];
        Arrays.fill(timetaken, Integer.MAX_VALUE);
        timetaken[k]=0;
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)-> a.time-b.time);
        q.add(new Pair(k,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int node=p.node;
            int time=p.time;
            for(Pair it:list.get(node)){
                int nextnode=it.node;
                int nexttime=it.time+time;
                if(nexttime<timetaken[nextnode]){
                    timetaken[nextnode]=nexttime;
                    q.add(new Pair(nextnode,nexttime));
                }
            }
        }

         int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (timetaken[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, timetaken[i]);
        }

        return maxTime;
    }
}