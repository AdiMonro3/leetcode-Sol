// Last updated: 13/09/2025, 01:51:44
class Solution {
    void findsubsets(int ind,int [] nums,List<Integer> templist, List<List<Integer>> result){
        result.add(new ArrayList<>(templist));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind&&nums[i]==nums[i-1]) continue;
            templist.add(nums[i]);
            findsubsets(i+1,nums,templist,result);
            templist.remove(templist.size()-1);
                    }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> templist= new ArrayList<>();
        Arrays.sort(nums);
        findsubsets(0,nums,templist,result);
        return result;
    }
}