// Last updated: 17/11/2025, 00:33:44
class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
          int n = nums.length;
        if (n < 3) return Integer.MIN_VALUE;

        class Pair {
            int val, idx;
            Pair(int v, int i) { val = v; idx = i; }
        }

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(nums[i], i));
        }

        // Get top 3 maximum candidates
        list.sort((a, b) -> Integer.compare(b.val, a.val));  // descending
        List<Pair> top3 = new ArrayList<>(list.subList(0, Math.min(3, n)));  // copy to avoid modification

        // Get bottom 3 minimum candidates
        list.sort((a, b) -> Integer.compare(a.val, b.val));  // ascending
        List<Pair> bottom3 = new ArrayList<>(list.subList(0, Math.min(3, n)));  // copy for safety

        int ans = Integer.MIN_VALUE;

        // Try all combinations
        for (Pair a : top3) {
            for (Pair b : top3) {
                if (a.idx == b.idx) continue;
                for (Pair c : bottom3) {
                    if (c.idx == a.idx || c.idx == b.idx) continue;
                    ans = Math.max(ans, a.val + b.val - c.val);
                }
            }
        }

        return ans;
    }
}