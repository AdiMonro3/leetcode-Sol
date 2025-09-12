// Last updated: 13/09/2025, 01:52:11
class Solution {

    public static void generate(int arr[],int target,ArrayList<Integer> temp,int idx ,ArrayList<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
       
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;

            temp.add(arr[i]);
            generate(arr,target-arr[i],temp,i+1,result);
            temp.remove(temp.size()-1);    
            
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            ArrayList<List<Integer>> result= new ArrayList<>();
            ArrayList<Integer> temp=new ArrayList<>();
            Arrays.sort(candidates);
            generate(candidates,target,temp,0,result);

            return result;



    }
}