// Last updated: 22/02/2026, 09:49:44
1class Solution {
2   
3    public boolean helper(String s,String t){
4        if(s.length()!=t.length()) return false;
5
6        int [] count=new int[10];
7        for(char ch:s.toCharArray()){
8            count[ch-'0']++;
9        }
10        for(char ch:t.toCharArray()){
11            count[ch-'0']--;
12        }
13        for(int x:count){
14            if(x!=0) return false;
15        }
16        return true;
17    }
18    public boolean isDigitorialPermutation(int n) {
19        String s = String.valueOf(n);
20
21        return helper(s, "1") ||
22               helper(s, "2") ||
23               helper(s, "145") ||
24               helper(s, "40585");
25    }
26}