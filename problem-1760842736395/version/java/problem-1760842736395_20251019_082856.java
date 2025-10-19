// Last updated: 19/10/2025, 08:28:56
class Solution {
    public int longestBalanced(int[] nums) {
           int[] arr = nums;

        int maxBalancedLength = 0;

        for (int startIndex = 0; startIndex < arr.length; startIndex++) {
            Set<Integer> distinctEvens = new HashSet<>();
            Set<Integer> distinctOdds = new HashSet<>();

            for (int endIndex = startIndex; endIndex < arr.length; endIndex++) {
                int currentNumber = arr[endIndex];

                if (currentNumber % 2 == 0) {
                    distinctEvens.add(currentNumber);
                } else {
                    distinctOdds.add(currentNumber);
                }

                if (distinctEvens.size() == distinctOdds.size()) {
                    int currentLength = endIndex - startIndex + 1;
                    maxBalancedLength = Math.max(maxBalancedLength, currentLength);
                }
            }
        }

        return maxBalancedLength;
    }
}