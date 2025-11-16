// Last updated: 17/11/2025, 00:34:44
import java.util.Arrays;
public class Solution{
    public int maximizeExpressionOfThree(int[]nums){
        Arrays.sort(nums);
        int n=nums.length;
        int a=nums[n-1];
        int b=nums[n-2];
        int c=nums[0];
        return a+b-c;
    }
    public static void main(String[]args){
        Solution sol=new Solution();
        int []nums1={1,4,2,5};
        int res1=sol.maximizeExpressionOfThree(nums1);
        System.out.println(res1);
        int []nums2={-2,0,5,-2,4};
        int res2=sol.maximizeExpressionOfThree(nums2);
        System.out.println(res2);
        
    }
}