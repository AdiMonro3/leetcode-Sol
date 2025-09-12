// Last updated: 13/09/2025, 01:51:49
class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void PowerSet(int idx,int []nums,List<Integer> temp){
       if(idx>=nums.length){
        ans.add(new ArrayList<>(temp));
        return;
       }
       temp.add(nums[idx]);
       PowerSet(idx+1,nums,temp);
       temp.remove(temp.size()-1);
       PowerSet(idx+1,nums,temp);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp=new ArrayList<>();
        PowerSet(0,nums,temp);
        return ans;
    }
}