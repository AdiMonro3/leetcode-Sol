// Last updated: 04/07/2026, 04:04:55
1import java.util.*;
2
3class Solution {
4    public String[] findRestaurant(String[] list1, String[] list2) {
5        Map<String, Integer> map = new HashMap<>();
6
7        for (int i = 0; i < list1.length; i++) {
8            map.put(list1[i], i);
9        }
10
11        List<String> result = new ArrayList<>();
12        int minSum = Integer.MAX_VALUE;
13
14        for (int j = 0; j < list2.length; j++) {
15            if (map.containsKey(list2[j])) {
16                int sum = j + map.get(list2[j]);
17
18                if (sum < minSum) {
19                    minSum = sum;
20                    result.clear();
21                    result.add(list2[j]);
22                } else if (sum == minSum) {
23                    result.add(list2[j]);
24                }
25            }
26        }
27
28        return result.toArray(new String[0]);
29    }
30}