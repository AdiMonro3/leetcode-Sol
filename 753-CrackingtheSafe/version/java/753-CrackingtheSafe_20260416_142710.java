// Last updated: 16/04/2026, 14:27:10
1class Solution {
2    StringBuilder ans=new StringBuilder();
3    HashSet<String> set=new HashSet<>();
4    int k;
5    public void helper(String node){
6        for(int d=0;d<k;d++){
7            String edge=node+d;
8
9            if(!set.contains(edge)){
10                set.add(edge);
11
12                helper(edge.substring(1));
13
14                ans.append(d);
15            }
16        }
17    }
18    public String crackSafe(int n, int k) {
19        this.k=k;
20        
21        String start="";
22        for(int i=0;i<n-1;i++){
23            start+='0';
24        }
25
26        helper(start);
27
28        ans.append(start);
29
30        return ans.toString();
31
32    }
33}