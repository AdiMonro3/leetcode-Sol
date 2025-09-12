// Last updated: 13/09/2025, 01:47:47
class Solution {
     public static boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length; // Size of the array
        int cnt = 0;
        int noOfB = 0;
        // Count the number of bouquets:
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long reqFlowers=(long)m*(long)k;
        if(bloomDay.length<reqFlowers) return -1;
         int mini = Integer.MAX_VALUE,  maxi = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        // Apply binary search:
        int low = mini,  high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }
}