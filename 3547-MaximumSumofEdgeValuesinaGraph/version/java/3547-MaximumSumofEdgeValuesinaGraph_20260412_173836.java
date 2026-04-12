// Last updated: 12/04/2026, 17:38:36
class Solution {
    public long maxScore(int n, int[][] edges) {
        int m = edges.length;
        
        long sum = 0;
        for(int i = 2 ; i<n-1 ; i+=2){
            sum+= (long)i*(long)(i+2);
        }
        //System.out.println(sum);
        for(int i = 1 ; i<n-1 ; i+=2){
            sum+= (long)i*(long)(i+2);
        }
        //System.out.println(sum);

        sum+= (long)n*(long)(n-1);

        if(m==n) sum+=2;

        return sum;
        
    }
}