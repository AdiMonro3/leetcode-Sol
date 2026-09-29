// Last updated: 29/09/2026, 22:48:57
1class Solution {
2    public int[] resultArray(int[] nums) {
3        int n = nums.length;
4        
5        // Use primitive arrays of size n to guarantee enough capacity
6        int[] arr1 = new int[n];
7        int[] arr2 = new int[n];
8        
9        // Pointers to track the sizes (and next insertion index) of arr1 and arr2
10        int count1 = 0;
11        int count2 = 0;
12        
13        // Distribute the first two elements
14        arr1[count1++] = nums[0];
15        arr2[count2++] = nums[1];
16        
17        // Distribute the remaining elements based on the last added elements
18        for (int i = 2; i < n; i++) {
19            if (arr1[count1 - 1] > arr2[count2 - 1]) {
20                arr1[count1++] = nums[i];
21            } else {
22                arr2[count2++] = nums[i];
23            }
24        }
25        
26        // Concatenate arr1 and arr2 into the result array
27        int[] result = new int[n];
28        
29        for (int i = 0; i < count1; i++) {
30            result[i] = arr1[i];
31        }
32        
33        for (int i = 0; i < count2; i++) {
34            result[count1 + i] = arr2[i];
35        }
36        
37        return result;
38    }
39}