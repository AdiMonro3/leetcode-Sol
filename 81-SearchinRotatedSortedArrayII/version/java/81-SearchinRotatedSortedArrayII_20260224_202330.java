// Last updated: 24/02/2026, 20:23:30
1class Solution {
2    public boolean search(int[] nums, int target) {
3        int lb=0;
4        int ub=nums.length-1;
5        while(lb<=ub){
6            int mid=lb+(ub-lb)/2;
7            if(nums[mid]==target) return true;
8            if(nums[lb]==nums[mid] && nums[mid]==nums[ub]){
9                lb++;
10                ub--;
11                continue;
12            }
13
14            if(nums[lb]<=nums[mid]){
15                if(nums[lb]<=target && target<=nums[mid]){
16                    ub=mid-1;
17                }
18                else{
19                    lb=mid+1;
20                } 
21            }
22            else{
23                if(nums[mid]<=target && target<=nums[ub]){
24                    lb=mid+1;
25                }
26                else{
27                    ub=mid-1;
28                }
29            }
30        }
31        return false;
32    }
33}