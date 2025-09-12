// Last updated: 13/09/2025, 01:47:53
class Solution {
   public static class DisjointSet{
        ArrayList<Integer> parent=new ArrayList<>();
        ArrayList<Integer> size=new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<=n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int FindUParent(int node){
            if(node==parent.get(node)) return node;
            int ulp=FindUParent(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);

        }
        public void UnionBySize(int u, int v){
            int ulp_u=FindUParent(u);
            int ulp_v=FindUParent(v);
            if(ulp_u==ulp_v) return;
            if(size.get(ulp_u)<size.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
            }
            else{
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        DisjointSet ds=new DisjointSet(n);
        int extraWires = 0;
        for(int[] it:connections){
            int node1=it[0];
            int node2=it[1];
            if(ds.FindUParent(node1)==ds.FindUParent(node2)){
                extraWires++;
            }else{
                ds.UnionBySize(node1,node2);
            }
        }
         int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.FindUParent(i) == i) components++;
        }
          int needed = components - 1;
        return extraWires >= needed ? needed : -1;
    }
}
