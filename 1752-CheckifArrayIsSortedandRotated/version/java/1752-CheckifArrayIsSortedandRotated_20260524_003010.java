// Last updated: 24/05/2026, 00:30:10
1class Solution {
2    public boolean check(int[] nums) {
3        int count =0;
4      for(int i=1;i<nums.length;i++){
5        if(nums[i-1]>nums[i]){
6            count++;
7            }
8      }
9      if(nums[nums.length-1]>nums[0]){
10        count++;
11      }    
12          
13       if(count>1){
14        return false;
15       }
16       
17      
18    return true;
19    }
20        
21    
22}