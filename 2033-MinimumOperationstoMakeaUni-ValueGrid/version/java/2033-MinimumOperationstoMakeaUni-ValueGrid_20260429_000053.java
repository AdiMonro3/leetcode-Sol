// Last updated: 29/04/2026, 00:00:53
1class Solution {
2    public int minimumDistance(int[] nums) {
3         Map<Integer, List<Integer>> map = new HashMap<>();
4        
5        // Step 1: store indices
6        for (int i = 0; i < nums.length; i++) {
7            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
8        }
9        
10        int ans = Integer.MAX_VALUE;
11        
12        // Step 2: process each number
13        for (List<Integer> list : map.values()) {
14            if (list.size() < 3) continue;
15            
16            // Step 3: check consecutive triples
17            for (int i = 0; i + 2 < list.size(); i++) {
18                int dist = 2 * (list.get(i + 2) - list.get(i));
19                ans = Math.min(ans, dist);
20            }
21        }
22        
23        return ans == Integer.MAX_VALUE ? -1 : ans;
24
25    }
26}