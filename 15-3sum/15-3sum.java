// Last updated: 13/09/2025, 01:52:33
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result= new ArrayList<>();
        
      for(int i=0;i<nums.length;i++){
        if (i != 0 && nums[i] == nums[i - 1]) continue;
        int j=i+1;
        int k=nums.length -1;
        while(j<k){
            int sum=nums[i]+nums[j]+nums[k];
            ArrayList<Integer> temp=new ArrayList<>();

            if(sum>0){
                k--;
            }
            else if(sum<0){
                j++;
            }
            else{
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(nums[k]);
                result.add(temp);
                
                while(j<k && nums[j]==nums[j+1]){
                    j++;
                }
                while(k>j && nums[k]==nums[k-1]){
                    k--;
                }
                j++;
                k--;
            }

        }
      }
      return result;
    }
}