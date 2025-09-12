// Last updated: 13/09/2025, 01:49:34
class Solution {
    public int arrangeCoins(int n) {
        long low = 0, high = n;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long curr = mid * (mid + 1) / 2;

            if (curr == n) {
                return (int)mid;
            } else if (curr < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int)high;
        
    }
}