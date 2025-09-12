// Last updated: 13/09/2025, 01:51:14
class Solution {
    public boolean isPalindrom(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public void part(String s,List<String> curr,List<List<String>> ans){
        if(s.length()==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String temp=s.substring(0,i);
            if(!isPalindrom(temp)) continue;
            curr.add(temp);
            part(s.substring(i,s.length()),curr,ans);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        part(s,new ArrayList<>(),ans);
        return ans;
    }
}