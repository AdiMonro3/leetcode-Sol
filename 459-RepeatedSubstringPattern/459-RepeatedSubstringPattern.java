// Last updated: 13/09/2025, 01:49:27
class Solution {
    public boolean repeatedSubstringPattern(String s) {
 String doubled = s + s;
        String trimmed = doubled.substring(1, doubled.length() - 1);
        return trimmed.contains(s);
    }
}