// Last updated: 31/01/2026, 13:33:35
1class Solution {
2    List<List<Integer>> result;
3    public void helper(int n,int k,int i,List<Integer> temp){
4        if(temp.size()==k){
5            result.add(new ArrayList<>(temp));
6            return;
7        }
8        if(i>n) return ;
9        temp.add(i);
10        helper(n,k,i+1,temp);
11        temp.remove(temp.size()-1);
12        helper(n,k,i+1,temp);
13    }
14    public List<List<Integer>> combine(int n, int k) {
15        result=new ArrayList<>();
16        List<Integer> temp=new ArrayList<>();
17        helper(n,k,1,temp);
18        return result;
19    }
20}