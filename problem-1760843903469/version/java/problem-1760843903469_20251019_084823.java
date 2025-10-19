// Last updated: 19/10/2025, 08:48:23
class Solution {
    private static boolean isPromising(StringBuilder path, String target){
        int len = path.length();
        if (len > target.length()) return true;
        String sub = target.substring(0, len);
        return path.toString().compareTo(sub) >= 0;
    }
    private static void backtrack(char[] chars, String target,StringBuilder path, boolean[] used, StringBuilder result, boolean[] found) {
        if (found[0]) return;

        if (path.length() == chars.length) {
            String candidate = path.toString();
            if (candidate.compareTo(target) > 0) {
                result.append(candidate);
                found[0] = true;
            }
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;

            // Skip duplicate characters
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            path.append(chars[i]);

            // Prune only if current prefix is strictly less than target prefix
            if (isPromising(path, target)) {
                backtrack(chars, target, path, used, result, found);
            }

            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }
    public String lexGreaterPermutation(String s, String target) {
        String t = s;

        char[] chars = t.toCharArray();
        Arrays.sort(chars); 

        StringBuilder result = new StringBuilder();
        boolean[] used = new boolean[chars.length];

        boolean[] found = {false};

        backtrack(chars, target, new StringBuilder(), used, result, found);
        return found[0] ? result.toString() : "";
    }
}