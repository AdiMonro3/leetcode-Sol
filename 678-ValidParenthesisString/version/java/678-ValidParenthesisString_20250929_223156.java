// Last updated: 29/09/2025, 22:31:56
class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int min=0;
        int max=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }
            else if(s.charAt(i)==')'){
               min--;
               max--; 
            }
            else{
                min--;
                max++;
            }
            if (max < 0) return false;
            if(min<0) min=0;
        }
        if(min==0) return true ;
        return false;
    }
}