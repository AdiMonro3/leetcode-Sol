// Last updated: 26/02/2026, 10:34:36
1class Solution {
2    public int helper(int[] nums,int k,int i,List<Integer> lst){
3        if(i>=nums.length) return 0;
4
5        boolean b=true;
6        for(int idx=0;idx<lst.size();idx++){
7            if(Math.abs(lst.get(idx)-nums[i])==k){
8                b=false;
9                break;
10            }
11        }
12        int pick=0;
13        int notpick=0;
14        if(b==true){
15            lst.add(nums[i]);
16            pick=1+helper(nums,k,i+1,lst);
17            lst.remove(lst.size()-1);
18        }
19        notpick=helper(nums,k,i+1,lst);
20
21        return pick+notpick;
22    }
23    public int beautifulSubsets(int[] nums, int k) {
24        int n=nums.length;
25        List<Integer> lst=new ArrayList<>();
26        return helper(nums,k,0,lst);
27
28    }
29}