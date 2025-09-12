// Last updated: 13/09/2025, 01:52:18
class Solution {
    public static void sort(int[] arr, int L, int R) {
        if (L < R) {
            int pivotIndex = partition(arr, L, R);
            sort(arr, L, pivotIndex - 1); // Sort left part
            sort(arr, pivotIndex + 1, R); // Sort right part
        }
    }

    private static int partition(int[] arr, int L, int R) {
        int pivot = arr[R]; // Choosing last element as pivot
        int i = L - 1;
        
        for (int j = L; j < R; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, R);
        return i + 1; // Return pivot index
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void nextPermutation(int[] nums) {
          int n = nums.length;
        int j = n - 1;
        
        // Step 1: Find the first decreasing element from the right
        while (j >= 1 && nums[j - 1] >= nums[j]) {
            j--;
        }
        
        if (j > 0) { // If such an element exists
            int i = n - 1;
            
            // Step 2: Find the smallest element on the right that is larger than nums[j-1]
            while (nums[i] <= nums[j - 1]) {
                i--;
            }
            
            // Step 3: Swap nums[j-1] and nums[i]
            swap(nums, j - 1, i);
        }
        
        // Step 4: Sort (or reverse) the right portion from j to n-1
        sort(nums, j, n - 1);
    }
       
        
    }
