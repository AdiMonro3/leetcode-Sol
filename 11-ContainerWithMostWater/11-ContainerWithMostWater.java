// Last updated: 13/09/2025, 01:52:37
class Solution {
    public int maxArea(int[] a) {
        int n = a.length;
        int max=0;
        int i = 0;
        int area  = 0;
        int j = n-1;
       while(i<j){
        if(a[i]<a[j]){
          area = a[i] *( j-i) ; 
          i++;
        }
        else{
         area = a[j]*(j-i);
         j--;
        }
        if(max<area)
        max = area;
       }
       return max ;
        
    }
}