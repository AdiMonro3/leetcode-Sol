// Last updated: 13/09/2025, 01:49:22
class Solution {
public int findMaxConsecutiveOnes(int[] arr) {
    int max = 0, currMax = 0;

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == 1) {
            currMax++;
        } else {
            max = Math.max(max, currMax);
            currMax = 0;
        }
    }
    
    return Math.max(max, currMax); // Final update if last sequence is max
}
        }
    