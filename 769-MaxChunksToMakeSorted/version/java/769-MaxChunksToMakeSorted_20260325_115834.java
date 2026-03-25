// Last updated: 25/03/2026, 11:58:34
1class Solution {
2    public int maxChunksToSorted(int[] arr) {
3        int n=arr.length;
4        int ans=0;
5        int i=0;
6        while(i<n){
7            int j=i;
8            int max=arr[i];
9            int min=arr[i];
10            while(j<n){
11
12                max=Math.max(max,arr[j]);
13                min=Math.min(min,arr[j]);
14
15                if(min==i && max==j){
16                    ans++;
17                    break;
18                }
19                j++;
20            }
21            i=j+1;
22        }
23        return ans;
24
25
26    }
27}