// Last updated: 29/01/2026, 13:04:28
1class Solution {
2    public int canCompleteCircuit(int[] gas, int[] cost) {
3        int n=gas.length;
4        int totalGas=0;
5        int totalCost=0;
6        for(int i=0;i<n;i++){
7            totalGas+=gas[i];
8            totalCost+=cost[i];
9        }
10        if(totalCost>totalGas) return -1;
11        int tank = 0;
12        int start = 0;
13
14        for (int i = 0; i < gas.length; i++) {
15            tank += gas[i] - cost[i];
16
17            if (tank < 0) {
18                // cannot start from start to i
19                tank = 0;
20                start = i + 1;
21            }
22        }
23        return start;
24    }
25}