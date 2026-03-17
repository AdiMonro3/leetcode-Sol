// Last updated: 17/03/2026, 13:05:53
1class Solution {
2    public List<List<Integer>> generate(int n) {
3        List<List<Integer>> ans=new ArrayList<>();
4
5        for(int i=0;i<n;i++){
6            ans.add(new ArrayList<>());
7        }
8
9        ans.get(0).add(1);
10
11        for(int i=1;i<n;i++){
12            int size=ans.get(i-1).size()+1;
13            for(int j=0;j<size;j++){
14                if(j==0 || j==size-1) ans.get(i).add(1);
15                else{
16                    int prev=ans.get(i-1).get(j-1);
17                    int curr=ans.get(i-1).get(j);
18
19                    ans.get(i).add(prev+curr);
20                }
21            }
22        }
23        return ans;
24        
25    }
26}