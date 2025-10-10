// Last updated: 10/10/2025, 16:32:42
class Solution {
    public boolean isvalid(String s,String t){
        Set<Character> set = new HashSet<>();
    
        // add all characters from t
        for (char c : t.toCharArray()) {
             if (!set.add(c)) return false;
        }

        // check if s has any character already in t
        for (char c : s.toCharArray()) {
            if (set.contains(c)) return false; // overlap found
        }

        return true;
    }
    public int helper(List<String> arr,int n,int i,String s){
        if(i>=n) return 0;
        int pick=0;
        if(isvalid(s,arr.get(i))){
            pick=arr.get(i).length()+helper(arr,n,i+1,s+arr.get(i));
        }
        int nonpick=helper(arr,n,i+1,s);
        return Math.max(pick,nonpick);
    }
    public int maxLength(List<String> arr) {
        // if(arr.size()==1) return arr.get(0).length();
        return helper(arr,arr.size(),0,"");
    }
}