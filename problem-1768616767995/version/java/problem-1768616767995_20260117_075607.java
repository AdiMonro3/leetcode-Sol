// Last updated: 17/01/2026, 07:56:07
1class Solution {
2    public int residuePrefixes(String s) {
3        HashSet<Character> set=new HashSet<>();
4        int n=s.length();
5        int count=0;
6        for(int i=0;i<n;i++){
7            set.add(s.charAt(i));
8            int prefixLen=i+1;
9            
10            if(prefixLen%3==set.size()){
11                count++;
12            }
13        }
14        return count;
15    }
16}