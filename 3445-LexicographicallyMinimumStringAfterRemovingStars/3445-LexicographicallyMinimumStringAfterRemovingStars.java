// Last updated: 12/09/2025, 15:03:06
class Solution {
    public String clearStars(String s) {
         Deque<Integer>[] cnt = new Deque[26];
        for (int i = 0; i < 26; i++) {
            cnt[i] = new ArrayDeque<>();
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                cnt[arr[i] - 'a'].push(i);
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!cnt[j].isEmpty()) {
                        arr[cnt[j].pop()] = '*';
                        break;
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}