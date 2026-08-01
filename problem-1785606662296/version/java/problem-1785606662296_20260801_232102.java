// Last updated: 01/08/2026, 23:21:02
1class Solution {
2    public int countValidPrefixes(String s) {
3        int validPre = 0;
4        int zeros = 0;
5        int ones = 0;
6        
7        for(int i=0;i<s.length();i++) {
8            char ch=s.charAt(i);
9            
10            if(ch=='0'){
11                zeros++;
12            }else{
13                ones++;
14            }
15            if (Math.abs(zeros - ones) <= 1) {
16                validPre++;
17            }
18        }
19        return validPre;
20    }
21}
22