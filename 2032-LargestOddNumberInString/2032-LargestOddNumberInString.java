// Last updated: 13/09/2025, 01:47:36
class Solution {
    public String largestOddNumber(String num) {
        int size=num.length();
        int index=-1;
        for(int i=size-1;i>=0;i--){
            int curr=num.charAt(i)-'0';
            if(curr%2!=0){
                index=i;
                break;
            }
        }
        if(index==-1) return "";
        
       
        return num.substring(0, index + 1);
    }
}
