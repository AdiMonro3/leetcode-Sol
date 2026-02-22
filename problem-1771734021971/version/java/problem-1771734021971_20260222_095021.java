// Last updated: 22/02/2026, 09:50:21
1class Solution {
2    public String maximumXor(String s, String t) {
3        int n=s.length();
4        int zeros=0;
5        int ones=0;
6
7        for(char ch:t.toCharArray()){
8            if(ch=='0') zeros++;
9            else ones++;
10        }
11        StringBuilder result=new StringBuilder();
12        for(int i=0;i<n;i++){
13            char sc=s.charAt(i);
14            if(sc=='0'){
15                if(ones>0){
16                    result.append('1');
17                    ones--;
18                }else{
19                    result.append('0');
20                    zeros--;
21                }
22            }else{
23                if(zeros>0){
24                    result.append('1');
25                    zeros--;
26                }else{
27                    result.append('0');
28                    ones--;
29                }
30            }
31        }
32        return result.toString();
33    }
34}