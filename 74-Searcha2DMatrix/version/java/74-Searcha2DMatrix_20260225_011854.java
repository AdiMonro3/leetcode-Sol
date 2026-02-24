// Last updated: 25/02/2026, 01:18:54
1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int rows = matrix.length;
4        int cols = matrix[0].length;
5
6        // Treat matrix as a flattened sorted array
7        int low = 0;
8        int high = rows * cols - 1;
9
10        while (low <= high) {
11
12            int mid = low + (high - low) / 2;
13
14            // Convert 1D index to 2D indices
15            int row = mid / cols;
16            int col = mid % cols;
17
18            int element = matrix[row][col];
19
20            if (element == target) {
21                return true;
22            }
23            else if (element < target) {
24                low = mid + 1;
25            }
26            else {
27                high = mid - 1;
28            }
29        }
30
31        return false; // not found
32    }
33}