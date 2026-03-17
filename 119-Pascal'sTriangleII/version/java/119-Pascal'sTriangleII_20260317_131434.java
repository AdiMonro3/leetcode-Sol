// Last updated: 17/03/2026, 13:14:34
1class Solution {
2    public List<Integer> getRow(int n) {
3       List<Integer> ans = new ArrayList<>();
4
5    long val = 1;
6
7    for(int k = 0; k <= n; k++){
8        ans.add((int)val);
9        val = val * (n - k) / (k + 1);
10    }
11
12    return ans;
13    }
14}