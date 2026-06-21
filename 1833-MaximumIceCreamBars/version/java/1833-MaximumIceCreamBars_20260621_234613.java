// Last updated: 21/06/2026, 23:46:13
1class Solution {
2    public int maxIceCream(int[] costs, int coins) {
3        Arrays.sort(costs);
4
5        int count = 0;
6
7        for (int cost : costs) {
8            if (coins < cost)
9                break;
10
11            coins -= cost;
12            count++;
13        }
14
15        return count;
16    }
17}