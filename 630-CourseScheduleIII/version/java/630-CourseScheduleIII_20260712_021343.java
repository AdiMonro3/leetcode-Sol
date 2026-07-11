// Last updated: 12/07/2026, 02:13:43
1class Solution {
2    public int scheduleCourse(int[][] courses) {
3        Arrays.sort(courses, (a, b) -> a[1] - b[1]); // by deadline
4        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
5        int time = 0;
6        for (int[] c : courses) {
7            time += c[0];
8            maxHeap.add(c[0]);
9            if (time > c[1]) {
10                time -= maxHeap.poll(); // evict the longest course taken so far
11            }
12        }
13        return maxHeap.size();
14    }
15}