// Last updated: 13/09/2025, 01:51:59


class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // If overlapping, merge intervals
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap, add the merged interval and move to the next
                merged.add(current);
                current = intervals[i];
            }
        }

        // Add the last merged interval
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    
    }
}