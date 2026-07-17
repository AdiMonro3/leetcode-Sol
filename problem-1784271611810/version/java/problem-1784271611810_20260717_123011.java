// Last updated: 17/07/2026, 12:30:11
1class Solution {
2    public int secondsBetweenTimes(String startTime, String endTime) {
3        String[] start = startTime.split(":");
4        String[] end = endTime.split(":");
5
6        // 1. Convert start time to total seconds
7        int startTotalSeconds = (Integer.parseInt(start[0]) * 3600) 
8                              + (Integer.parseInt(start[1]) * 60) 
9                              + Integer.parseInt(start[2]);
10
11        // 2. Convert end time to total seconds
12        int endTotalSeconds = (Integer.parseInt(end[0]) * 3600) 
13                            + (Integer.parseInt(end[1]) * 60) 
14                            + Integer.parseInt(end[2]);
15
16        // 3. Return the absolute difference
17        return endTotalSeconds - startTotalSeconds;
18    }
19}
20