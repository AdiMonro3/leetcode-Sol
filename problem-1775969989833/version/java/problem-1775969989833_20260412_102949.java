// Last updated: 12/04/2026, 10:29:49
1class Solution {
2    public int countDigitOccurrences(int[] nums, int digit) {
3
4        char target=(char)(digit+'0');
5        int count=0;
6
7        for(int num: nums){
8            String s=String.valueOf(num);
9
10            for(int i=0;i<s.length();i++){
11                if(s.charAt(i)==target){
12                    count++;
13                }
14            }
15            
16        }
17        return count;
18    }
19}