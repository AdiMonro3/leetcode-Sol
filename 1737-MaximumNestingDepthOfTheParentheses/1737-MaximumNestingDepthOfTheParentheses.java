// Last updated: 13/09/2025, 01:47:42
class Solution {
    public int maxDepth(String s) {
        int depth = 0, maxDepth = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (c == ')') {
                depth--;
            }
        }
        
        return maxDepth;
    }
}
    