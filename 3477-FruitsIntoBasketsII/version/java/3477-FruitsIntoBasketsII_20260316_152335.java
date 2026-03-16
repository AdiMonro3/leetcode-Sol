// Last updated: 16/03/2026, 15:23:35
1class Solution {
2    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
3        int n=fruits.length;
4        int m=baskets.length;
5        int filled[]=new int[m];
6        int notPlaced=0;
7
8        for(int i=0;i<n;i++){
9            boolean placeFound=false;
10            for(int j=0;j<m;j++){
11                int quantity=fruits[i];
12
13                if(baskets[j]>=quantity && filled[j]!=1){
14                    filled[j]=1;
15                    placeFound=true;
16                    break;
17                }
18            }
19            if(!placeFound) notPlaced++;
20        }
21        return notPlaced;
22    }
23}