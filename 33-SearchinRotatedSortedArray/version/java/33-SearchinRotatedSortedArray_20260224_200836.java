// Last updated: 24/02/2026, 20:08:36
1class Solution {
2    public int search(int[] nums, int target) {
3        int lb=0;
4        int ub=nums.length-1;
5        while(lb<=ub){
6            boolean sorted=false;
7            int mid=lb+(ub-lb)/2;
8            if(nums[mid]==target){
9                return mid;
10            }
11            if(nums[lb]<=nums[mid]){
12                sorted=true;
13            }
14            if(sorted){
15                if(nums[lb]<=target && target<=nums[mid]){
16                    ub=mid-1;
17                }
18                else{
19                    lb=mid+1;
20                }
21
22            }
23            else{
24                if(nums[mid]<=target && target<=nums[ub]){
25                        lb=mid+1;
26                    }
27                    else{
28                        ub=mid-1;
29                    }
30            }
31        }
32        return -1;
33    }
34}