// Last updated: 13/09/2025, 01:50:13
class Solution {
    public int missingNumber(int[] a) {
    
     int n = a.length;
     int b = (n*(n+1))/2;
     int c= 0;
     for(int i = 0;i<n;i++){
        c = c+a[i];
     }
     return b-c;
    }
}