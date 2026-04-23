// Last updated: 24/04/2026, 00:40:48
1class Solution {
2    public int findLHS(int[] nums) {
3         HashMap<Integer, Integer> map = new HashMap<>();
4        
5        // Step 1: Count frequency
6        for (int num : nums) {
7            map.put(num, map.getOrDefault(num, 0) + 1);
8        }
9        
10        int maxLen = 0;
11        
12        // Step 2: Check pairs (x, x+1)
13        for (int key : map.keySet()) {
14            if (map.containsKey(key + 1)) {
15                int currLen = map.get(key) + map.get(key + 1);
16                maxLen = Math.max(maxLen, currLen);
17            }
18        }
19        
20        return maxLen;
21    }
22}