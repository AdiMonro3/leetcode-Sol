// Last updated: 13/09/2025, 01:51:16
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

    int count = 1;
    HashSet<Integer> map = new HashSet<>();
    for (int num : nums) {
        map.add(num);
    }

    for (int num : map) {
        if (!map.contains(num - 1)) { 
            int tempcnt = 1;
            int x = num;
            while (map.contains(x + 1)) {
                x++;
                tempcnt++;
            }
            count = Math.max(count, tempcnt);
        }
    }

    return count;

    }
}