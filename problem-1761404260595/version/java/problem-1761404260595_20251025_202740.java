// Last updated: 25/10/2025, 20:27:40
class Solution {
    public String lexSmallest(String s) {
        int n = s.length();
        String smallest = s;
        for (int k = 1; k <= n; k++) {
            String firstRev = new StringBuilder(s.substring(0, k))
                .reverse()
                .append(s.substring(k))
                .toString();

                // Reverse last k characters
            String lastRev = s.substring(0, n - k) +new StringBuilder(s.substring(n - k))
                    .reverse()
                    .toString();

                    // Update smallest string
                    if (firstRev.compareTo(smallest) < 0)
                        smallest = firstRev;
                    if (lastRev.compareTo(smallest) < 0)
                        smallest = lastRev;
                }

                return smallest;
    }
}