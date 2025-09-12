// Last updated: 13/09/2025, 01:49:24
class Solution {
    public int findComplement(int num) {
        int mask = 0;
        int temp = num;
        
        // Create a mask with all 1's of the same bit-length as num
        while (temp != 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }
        
        // XOR num with the mask to flip its bits
        return num ^ mask;
    }
}