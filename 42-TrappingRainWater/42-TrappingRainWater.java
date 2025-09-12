// Last updated: 13/09/2025, 01:52:09
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int count=0;
        int maxleft=0;
        int maxright=0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=maxleft){
                    maxleft=height[left];
                }else{
                    int x=maxleft-height[left];
                    if(x>0){
                        count+=x;
                        }
                }
                left++;
            }else{
                if(height[right]>=maxright){
                    maxright=height[right];
                }else{
                     int y=maxright-height[right];
                     if(y>0){
                        count+=y;
                        }
                }
                right--;
            }
        }
        return count;
    }
}