// Last updated: 13/09/2025, 01:52:13
class Solution {
    public static void findcombination(int i,int target,List<Integer> templist,int [] candidates,List<List<Integer>> result){
        if(candidates==null) return;
        if(target==0){
            result.add( new ArrayList<>(templist));
            return;
        }
        if(i==candidates.length) return;
        

        if(candidates[i]<=target){
            templist.add(candidates[i]);
            findcombination(i,target-candidates[i],templist,candidates,result);
            templist.remove(templist.size()-1);
            }

            findcombination(i+1,target,templist,candidates,result);
        

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     List<Integer> templist= new ArrayList<>();
     List<List<Integer>> result= new ArrayList<>();
     findcombination(0,target,templist,candidates,result);
     return result;
    } 
}