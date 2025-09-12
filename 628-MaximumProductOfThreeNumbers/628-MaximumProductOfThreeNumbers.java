// Last updated: 13/09/2025, 01:48:50
class Solution {
    public int maximumProduct(int[] a) {
       Arrays.sort(a);
        int n = a.length;
      //  int j = n-1 ;
        int k =0 ;
        int o  = a[n-1]*a[n-1-1]*a[n-1-2];
        int l = a[0]*a[1]*a[n-1];
       // int m = a[0]*a[1]*a[2];
         if(o>l || o==l)
         k=o;
         if(l>o||l==o)
          k=l ;
        //  if(m>l&&m>o)
        //  k =m ;
        return k ;
        
    }
}