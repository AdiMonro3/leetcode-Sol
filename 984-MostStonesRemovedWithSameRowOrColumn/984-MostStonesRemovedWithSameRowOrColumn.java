// Last updated: 13/09/2025, 01:48:21
class Solution {
    class DisjointSet{
        ArrayList<Integer> parent=new ArrayList<>();
        ArrayList<Integer> size=new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<=n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        public  int FindUParent(int node){
            if(node==parent.get(node)) return node;
            int ulp=FindUParent(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
        public void UnionBySize(int u,int v){
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
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int maxrow=0;
        int maxcol=0;
        for(int[] it:stones){
            int noderow=it[0];
            int nodecol=it[1];
            maxrow=Math.max(maxrow,noderow);
            maxcol=Math.max(maxcol,nodecol);
        }
        DisjointSet ds=new DisjointSet(maxrow+maxcol+1);
        HashMap<Integer,Integer> stoneNodes=new HashMap<>();
        for(int[]it:stones){
            int u=it[0];
            int v=it[1]+maxrow+1;
            ds.UnionBySize(u,v);
            stoneNodes.put(u,1);
            stoneNodes.put(v,1);

        }
         int cnt = 0;
        for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            if (ds.FindUParent(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }
        return n - cnt;
    
    }
}