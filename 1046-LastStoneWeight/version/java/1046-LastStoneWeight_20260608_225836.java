// Last updated: 08/06/2026, 22:58:36
1class Solution {
2    public int lastStoneWeight(int[] stones) {
3
4        PriorityQueue<Integer> pq =
5                new PriorityQueue<>(Collections.reverseOrder());
6
7        for(int stone : stones) {
8            pq.offer(stone);
9        }
10
11        while(pq.size() > 1) {
12
13            int y = pq.poll(); // largest
14            int x = pq.poll(); // second largest
15
16            if(y != x) {
17                pq.offer(y - x);
18            }
19        }
20
21        return pq.isEmpty() ? 0 : pq.poll();
22    }
23}