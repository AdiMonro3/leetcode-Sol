// Last updated: 13/09/2025, 01:52:20
class Solution {
    public int strStr(String haystack, String needle) {
         int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}