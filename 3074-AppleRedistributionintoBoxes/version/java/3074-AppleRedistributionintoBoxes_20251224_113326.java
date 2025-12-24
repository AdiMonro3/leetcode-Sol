// Last updated: 24/12/2025, 11:33:26
1class Solution {
2    public int minimumBoxes(int[] apple, int[] capacity) {
3         int totalApples = 0;
4        for (int a : apple) {
5            totalApples += a;
6        }
7
8        // Sort capacities in descending order
9        Arrays.sort(capacity);
10
11        int boxes = 0;
12        for (int i = capacity.length - 1; i >= 0 && totalApples > 0; i--) {
13            totalApples -= capacity[i];
14            boxes++;
15        }
16
17        return boxes;
18    }
19}