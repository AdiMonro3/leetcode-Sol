// Last updated: 13/09/2025, 01:48:58
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int prev=sum-k;
            count+=map.getOrDefault(prev,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}