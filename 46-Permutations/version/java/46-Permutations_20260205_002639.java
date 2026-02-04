// Last updated: 05/02/2026, 00:26:39
1class Solution {
2    void findpermutation(int[] nums,boolean []map, List<List<Integer>> result, List<Integer> templist){
3        if(templist.size()==nums.length){
4            result.add(new ArrayList<>(templist));
5        }
6        for(int i=0;i<nums.length;i++){
7            if(!map[i]){
8                map[i]=true;
9                templist.add(nums[i]);
10                findpermutation(nums,map,result,templist);
11                templist.remove(templist.size()-1);
12                map[i]=false;
13            }
14        }
15    }
16    public List<List<Integer>> permute(int[] nums) {
17        List<List<Integer>> result = new ArrayList<>();
18        List<Integer> templist= new ArrayList<>();
19        boolean[] map=new boolean[nums.length];
20        Arrays.sort(nums);
21        findpermutation(nums,map,result,templist);
22        return result;
23        
24    }
25}