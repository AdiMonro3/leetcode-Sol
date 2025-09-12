// Last updated: 13/09/2025, 01:52:45
class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer> map= new HashMap<>();
       int sum=0;
       int []result=new int[2];
       for(int i=0;i<nums.length;i++){
                sum=nums[i];
                int second=target-sum;
                if(map.containsKey(second)){
                    result[0]=map.get(second);
                    result[1]=i;
                    return result;
                }
                if(!map.containsKey(sum)){
                    map.put(sum,i);
                }
       }
        return result;
    }
}