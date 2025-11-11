// Last updated: 11/11/2025, 15:06:34
class Solution {
    class DSU{
        int [] parent;
        int [] rank;
        int count;
        public DSU(int n){
           count=n-1;
            parent=new int[n];
            rank=new int[n];

            for(int i=1;i<n;i++){
                parent[i]=i;
                rank[i]=0;
            }
        }

        public int find(int u){
            if(parent[u]==u) return u;

            parent[u]=find(parent[u]);

            return parent[u];
        }

        public void Union(int u,int v){
            int uP=find(u);
            int vP=find(v);

            if(uP==vP) return;

            if(rank[uP]>rank[vP]){
                parent[vP]=uP;
            }
            else if(rank[uP]<rank[vP]){
                parent[uP]=vP;
            }
            else{
                parent[vP]=uP;
                rank[uP]++;
            }
            count--;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice=new DSU(n+1);
        DSU bob=new DSU(n+1);

        Arrays.sort(edges, (a, b) -> b[0] - a[0]);

        int edge=0;
        for(int[] it:edges){
            int type=it[0];
            int u=it[1];
            int v=it[2];

            if(type==1){
                if(alice.find(u) == alice.find(v)) continue;

                alice.Union(u,v);
                edge++;

            }
            else if(type==2){
                if(bob.find(u) == bob.find(v)) continue;

                bob.Union(u,v);
                edge++;
              
            }
            else{
                boolean edgeAdded=false;
                if(alice.find(u) != alice.find(v)){
                    alice.Union(u,v);
                    edgeAdded=true;
                   
                }
                if(bob.find(u) != bob.find(v)){
                    bob.Union(u,v);
                    edgeAdded=true;
                    
                }
                if(edgeAdded) edge++;
            }

       }
       if(alice.count==1 && bob.count==1){
        return edges.length-edge;
       }
        return -1;
    }
}