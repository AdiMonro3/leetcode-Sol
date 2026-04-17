// Last updated: 17/04/2026, 11:12:06
class Solution {
    public int minDeletionSize(String[] strs) {
//we need to check fir each word by itsrating on ots row for a particular index wheather it is lexicographically or not;
int minDel=0;
int n=strs.length;
int m=strs[0].length();
//valid array to check whether a previous row is valid or not even if character mismatch this for of all characters are same at particular indrx;
boolean[] valid=new boolean[n-1];
for(int col=0;col<m;col++){
boolean delete=false;
for(int r=0;r<n-1;r++){
if(!valid[r] && strs[r].charAt(col)>strs[r+1].charAt(col)){
minDel++;
delete=true;
break;//we have to delete all col;
}
}
if(delete) continue;
//mark the row if its valid!
for(int i=0;i<n-1;i++){
valid[i]=valid[i] | strs[i].charAt(col)<strs[i+1].charAt(col);
}
}
return minDel;
    }
}