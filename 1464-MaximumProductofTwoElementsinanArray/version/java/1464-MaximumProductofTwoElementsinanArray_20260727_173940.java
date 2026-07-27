// Last updated: 27/07/2026, 17:39:40
1class Solution {
2    public int maxProduct(int[] nums) {
3        int n=nums.length;
4        int m1=Integer.MIN_VALUE;
5        int m2=Integer.MIN_VALUE;
6
7        for(int i:nums){
8
9            if(i>=m1){
10                m2=m1;
11                m1=i;
12                
13            }
14            else if(i<m1 && i>=m2){
15                m2=i;
16            }
17
18        }
19        return (m1-1)*(m2-1);
20    }
21}