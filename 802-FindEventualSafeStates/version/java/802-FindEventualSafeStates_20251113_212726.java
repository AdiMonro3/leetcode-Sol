// Last updated: 13/11/2025, 21:27:26
class Solution {
    class Pair{
        String city;
        int edge;
        public Pair(String city,int edge){
            this.edge=edge;
            this.city=city;
        }
    }
    public void dfs(HashMap<String,List<Pair>> adj,boolean[] visited,Pair p,List<String> res){
        String u =p.city;
        int v=p.edge;
        
        if(!adj.containsKey(u)) return;

        for(Pair temp:adj.get(u)){
            String city =temp.city;
            int edge=temp.edge;

            if(visited[edge]==false){
                visited[edge]=true;
                // res.add(city);
                dfs(adj,visited,temp,res);
                res.add(city);  
            }
        } 
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        int n=tickets.size();

        HashMap<String,List<Pair>> adj=new HashMap<>();
       boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){

            String u=tickets.get(i).get(0);
            String v=tickets.get(i).get(1);

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v,i));//“If u doesn’t exist, create a new ArrayList for it; then add v to it.”
        }

        for (List<Pair> neighbors : adj.values()) {
            Collections.sort(neighbors, (a, b) -> a.city.compareTo(b.city));
        }

        List<String> res=new ArrayList<>();

        dfs(adj,visited,new Pair("JFK",-1),res);
        res.add("JFK");

        Collections.reverse(res);

        return res;
    }
}