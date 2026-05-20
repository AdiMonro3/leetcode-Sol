// Last updated: 20/05/2026, 11:34:48
1/** 
2 * Forward declaration of guess API.
3 * @param  num   your guess
4 * @return 	     -1 if num is higher than the picked number
5 *			      1 if num is lower than the picked number
6 *               otherwise return 0
7 * int guess(int num);
8 */
9
10public class Solution extends GuessGame {
11    public int guessNumber(int n) {
12        int low = 1;
13        int high = n;
14
15        while (low <= high) {
16
17            int mid = low + (high - low) / 2;
18
19            int result = guess(mid);
20
21            if (result == 0) {
22                return mid;
23            }
24            else if (result == -1) {
25                high = mid - 1;
26            }
27            else {
28                low = mid + 1;
29            }
30        }
31
32        return -1;
33    }
34}