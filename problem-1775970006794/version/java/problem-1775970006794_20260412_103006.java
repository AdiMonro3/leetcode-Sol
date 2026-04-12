// Last updated: 12/04/2026, 10:30:06
1class Solution {
2    public String trafficSignal(int timer) {
3        if (timer==0) {
4            return "Green";
5        } else if (timer==30) {
6            return "Orange";
7        } else if (timer>30&&timer<=90) {
8            return "Red";
9        } else {
10            return "Invalid";
11        }
12    }
13}