// Last updated: 10/12/2025, 23:29:56
1class Solution {
2    int n;
3    int dp[];
4    public boolean isvalid(String temp){
5        if(temp.length()>2) return false;
6        if(temp.charAt(0)=='0') return false;
7        int sValue = Integer.parseInt(temp);
8
9        if (sValue <= 26) return true ;
10
11        return false;
12
13    }
14    public int helper(String s,int idx){
15        if(idx>=n) return 1;
16        if (dp[idx] != -1) return dp[idx];         
17        String temp="";
18        int result=0;
19        for(int k=idx;k<n;k++){
20            temp=temp+s.charAt(k);
21            if(isvalid(temp)){
22                result+=helper(s,k+1);
23            }else {
24                break;                               // further chars will only make it invalid
25            }
26        }
27          return dp[idx] = result;       
28    }
29    public int numDecodings(String s) {
30        n=s.length();
31        dp = new int[n];
32        Arrays.fill(dp, -1);
33        return helper(s,0);
34    }
35}