// Last updated: 13/09/2025, 01:50:25
class Solution {
    public boolean isPowerOfTwo(int n) {
   if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
    }
