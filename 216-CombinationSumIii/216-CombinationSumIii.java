// Last updated: 13/09/2025, 01:50:37
class Solution {
    public static void porn(int k , int n , int idx ,  List<List<Integer>> ans , List<Integer> ls, int sum ) {
        if(idx == 10){
            if(ls.size() == k && sum == n){
                  ans.add(new ArrayList<>(ls));
            }
            return;
        }
        if(idx > 10 || sum > n) return;
         ls.add(idx);
        porn(k , n , idx +1 , ans , ls , sum + idx);
        ls.remove(ls.size() - 1);
        porn(k , n , idx +1 , ans , ls , sum );
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls  = new ArrayList<>();

        porn(k , n , 1 , ans,ls ,0 );
        return ans;
    }
}