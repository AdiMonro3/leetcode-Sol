// Last updated: 18/06/2026, 13:43:02
1class Solution {
2    public double angleClock(int hour, int minutes) {
3
4        double hourAngle = (hour % 12) * 30 + minutes * 0.5;
5        double minuteAngle = minutes * 6;
6
7        double diff = Math.abs(hourAngle - minuteAngle);
8
9        return Math.min(diff, 360 - diff);
10    }
11}