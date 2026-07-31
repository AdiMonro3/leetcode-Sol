// Last updated: 01/08/2026, 00:52:19
1class Solution {
2    public int maxProduct(int n) {
3        int max1 = 0;
4        int max2 = 0;
5        
6        // Extract digits mathematically using remainder and division
7        while (n > 0) {
8            int digit = n % 10;
9            
10            if (digit > max1) {
11                max2 = max1; // Move old max1 down to max2
12                max1 = digit; // Set new highest digit
13            } else if (digit > max2) {
14                max2 = digit; // Set new second-highest digit
15            }
16            
17            n /= 10; // Remove the last digit
18        }
19        
20        return max1 * max2;
21    }
22}
23