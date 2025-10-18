// Last updated: 18/10/2025, 13:28:15
class Solution {
    int dp[];
    public int helper(String s,int n,HashSet<String> set,int i){
        if (i >= n) return 0; // base case: no more chars left

        if (dp[i] != -1) return dp[i]; // memoization check

        // Option 1: skip current character (count it as extra)
        int notTake = 1 + helper(s,n,set ,i + 1);

        // Option 2: try taking valid words
        int take = Integer.MAX_VALUE;
        String temp = "";
        for (int j = i; j < n; j++) {
            temp += s.charAt(j);
            if (set.contains(temp)) {
                take = Math.min(take, helper(s,n,set, j + 1));
            }
        }

        return dp[i] = Math.min(take, notTake);

    }
    public int tabulate(String s,int n,HashSet<String> set){
         int[] dp = new int[n + 1];
        // dp[i] = minimum extra chars needed from index i to end
        dp[n] = 0; // base case: no extra characters after end

        for (int i = n - 1; i >= 0; i--) {
            // Option 1: skip current character
            int notTake = 1 + dp[i + 1];
            int take = Integer.MAX_VALUE;

            String temp = "";
            for (int j = i; j < n; j++) {
                temp += s.charAt(j); // build substring s[i...j]
                if (set.contains(temp)) {
                    take = Math.min(take, dp[j + 1]); // valid word, jump ahead
                }
            }

            dp[i] = Math.min(notTake, take);
        }

        return dp[0];
    }
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<dictionary.length;i++){
            set.add(dictionary[i]);
        }
        dp=new int[n];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        // return helper(s,n,set,0);
        return tabulate(s,n,set);
    }
}