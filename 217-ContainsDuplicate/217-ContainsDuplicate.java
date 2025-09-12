// Last updated: 13/09/2025, 01:50:35
class Solution {
    public boolean containsDuplicate(int[] a) {
       int n = a.length;
       boolean b = false;
       Arrays.sort(a);
       for(int i = 1; i<n ; i++){
        if(a[i-1]==a[i]){
        b = true;
        return b ;
        }
       }
    
return b;
    }
}
    
