// Last updated: 13/09/2025, 01:49:25
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += xor & 1;
            xor >>= 1;
        }
        return distance;
    }
}