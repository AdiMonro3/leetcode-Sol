// Last updated: 11/10/2025, 20:08:59
class Solution {
    public boolean scoreBalance(String s) {
         int n = s.length();

        if (n < 2) {
            return false;
        }

        long[] prefixScores = new long[n + 1];
        prefixScores[0] = 0;

        for (int i = 0; i < n; i++) {
            long charScore = s.charAt(i) - 'a' + 1;
            prefixScores[i + 1] = prefixScores[i] + charScore;
        }

        long totalScore = prefixScores[n];

        if (totalScore % 2 != 0) {
            return false;
        }

        long targetScore = totalScore / 2;

        for (int i = 1; i < n; i++) {
   
            if (prefixScores[i] == targetScore) {
                return true;
            }
        }

        return false;
    }
}