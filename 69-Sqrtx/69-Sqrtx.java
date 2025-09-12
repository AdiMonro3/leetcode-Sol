// Last updated: 13/09/2025, 01:51:54
class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = 1, right = x / 2;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // To prevent overflow, compare like this:
            if (mid <= x / mid) {
                result = mid; // this could be the answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}