// Last updated: 13/09/2025, 01:47:50
class Solution {
    public static int min(int arr[]){
       int mini = Math.min(arr[0], Math.min(arr[1], arr[2]));
       return mini;
    }
    public int numberOfSubstrings(String s) {
        int arr[]={-1,-1,-1};
        int i=0;
        int count=0;
        for(int j=0;j<s.length();j++){
            arr[s.charAt(j) - 'a']=j;
            if(arr[0]!=-1 && arr[1]!=-1 && arr[2]!=-1){
                count+=1+min(arr);
            }
        }
        return count;
    }
}