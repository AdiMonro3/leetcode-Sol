// Last updated: 13/09/2025, 01:52:07
class Solution {
    void findpermutation(int[] nums,boolean []map, List<List<Integer>> result, List<Integer> templist){
        if(templist.size()==nums.length){
            result.add(new ArrayList<>(templist));
        }
        for(int i=0;i<nums.length;i++){
            if(!map[i]){
                map[i]=true;
                templist.add(nums[i]);
                findpermutation(nums,map,result,templist);
                templist.remove(templist.size()-1);
                map[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> templist= new ArrayList<>();
        boolean[] map=new boolean[nums.length];
        Arrays.sort(nums);
        findpermutation(nums,map,result,templist);
        return result;
        
    }
}