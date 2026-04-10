// Last updated: 10/04/2026, 15:24:45
1class Solution {
2    
3    public int minMoves2(int[] nums) {
4
5        int n=nums.length;
6
7        Arrays.sort(nums);
8
9        int moves=0;
10
11        int mid=(0+n)/2;
12        for(int i=0;i<n;i++){
13            moves+=Math.abs(nums[i]-nums[mid]);
14        }
15
16        return moves;
17        
18    }
19}