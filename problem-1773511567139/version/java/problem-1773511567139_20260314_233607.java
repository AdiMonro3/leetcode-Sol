// Last updated: 14/03/2026, 23:36:07
1class Solution {
2    public int firstUniqueEven(int[] nums) {
3        int n=nums.length;
4
5        HashMap<Integer,Integer> map=new HashMap<>();
6 
7
8        for(int i=0;i<nums.length;i++){
9            if(nums[i]%2==0){
10                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
11            }
12        }
13
14        for(int i=0;i<n;i++){
15            if(nums[i]%2==0 && map.get(nums[i])==1 ){
16                return nums[i];
17               
18            }
19        }
20        return -1;
21    }
22}