// Last updated: 13/10/2025, 17:31:26
class Solution {
    public int nthUglyNumber(int n) {
        int []arr=new int [n+1];
        int i1=1;
        int i2=1;
        int i3=1;
        arr[1]=1;
        int j=2;
        while(j<=n){
            int ans1=2*arr[i1];
            int ans2=3*arr[i2];
            int ans3=5*arr[i3];
            int min=Math.min(ans1,Math.min(ans2,ans3));
            arr[j]=min;
            j++;
            if(min==ans1) i1++;
            if(min==ans2) i2++;
            if(min==ans3) i3++;
        } 
        return arr[n];
    }
}