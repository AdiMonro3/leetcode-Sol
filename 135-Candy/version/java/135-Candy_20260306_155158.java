// Last updated: 06/03/2026, 15:51:58
1class Solution {
2    public int candy(int[] rat) {
3        int n=rat.length;
4        int min=n;
5
6        int[] candies=new int[n];
7        Arrays.fill(candies,1);
8
9        //L2R
10        for(int i=1;i<n;i++){
11            if(rat[i]>rat[i-1]){
12                candies[i]=1+candies[i-1];
13            }
14        }
15
16        //R2L
17        for(int i=n-2;i>=0;i--){
18            if(rat[i]>rat[i+1]){
19                candies[i]=Math.max(candies[i],1+candies[i+1]);
20            }
21        }
22        
23        int sum=0;
24        for(int i=0;i<n;i++){
25            sum+=candies[i];
26        }
27
28        return sum;
29    }
30}