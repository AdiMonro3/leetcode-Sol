// Last updated: 05/03/2026, 13:22:18
1class Solution {
2    int helper(String s,int prev){
3        int flips=0;
4        for(int i=1;i<s.length();i++){
5            if(s.charAt(i)=='1' && prev==0){
6                prev=1;
7            }
8            else if(s.charAt(i)=='0' && prev==0){
9                flips++;
10                prev=1;
11            }
12            else if(s.charAt(i)=='1' && prev==1){
13                flips++;
14                prev=0;
15            }
16            else{
17                prev=0;
18            }
19        }
20        return flips;
21    }
22    public int minOperations(String s) {
23        int start=s.charAt(0)-'0';
24
25        int a=(start==0)?helper(s,0) : 1+helper(s,0);
26        int b=(start==1)?helper(s,1) : 1+helper(s,1);
27
28        return Math.min(a,b);
29    }
30}