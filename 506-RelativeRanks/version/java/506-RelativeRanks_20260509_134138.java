// Last updated: 09/05/2026, 13:41:38
1class Solution {
2    public String[] findRelativeRanks(int[] score) {
3         int n = score.length;
4        String[] answer = new String[n];
5        
6        // Step 1: Pair (score, index)
7        int[][] arr = new int[n][2];
8        for (int i = 0; i < n; i++) {
9            arr[i][0] = score[i];
10            arr[i][1] = i;
11        }
12        
13        // Step 2: Sort in descending order
14        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
15        
16        // Step 3: Assign ranks
17        for (int i = 0; i < n; i++) {
18            int index = arr[i][1];
19            
20            if (i == 0) answer[index] = "Gold Medal";
21            else if (i == 1) answer[index] = "Silver Medal";
22            else if (i == 2) answer[index] = "Bronze Medal";
23            else answer[index] = String.valueOf(i + 1);
24        }
25        
26        return answer;
27    }
28}