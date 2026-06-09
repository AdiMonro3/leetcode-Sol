// Last updated: 09/06/2026, 19:51:02
1class Solution {
2    public int[] pivotArray(int[] nums, int pivot) {
3
4        List<Integer> less = new ArrayList<>();
5        List<Integer> equal = new ArrayList<>();
6        List<Integer> greater = new ArrayList<>();
7
8        for(int num : nums) {
9            if(num < pivot) {
10                less.add(num);
11            } 
12            else if(num == pivot) {
13                equal.add(num);
14            } 
15            else {
16                greater.add(num);
17            }
18        }
19
20        int[] ans = new int[nums.length];
21        int idx = 0;
22
23        for(int num : less) {
24            ans[idx++] = num;
25        }
26
27        for(int num : equal) {
28            ans[idx++] = num;
29        }
30
31        for(int num : greater) {
32            ans[idx++] = num;
33        }
34
35        return ans;
36    }
37}