// Last updated: 13/09/2025, 01:50:09
class Solution {
   
    public void moveZeroes(int[] arr) {
      int i=0;
      for(int j=i+1;j<arr.length;j++){
        if(arr[i]!=0){
            i++;
        }
        else{
            if(arr[i]!=arr[j]){
                 int temp=arr[i];
                     arr[i]=arr[j];
                    arr[j]=temp;
                i++;
            }
        }
      }

    }
}