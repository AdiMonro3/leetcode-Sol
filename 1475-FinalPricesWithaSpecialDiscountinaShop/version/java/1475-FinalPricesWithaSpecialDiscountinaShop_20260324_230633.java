// Last updated: 24/03/2026, 23:06:33
1class Solution {
2    public int[] finalPrices(int[] nums) {
3        int n=nums.length;
4        int ans[]=nums;
5
6        ArrayDeque<Integer> st=new ArrayDeque<>();
7
8        for(int i=0;i<n;i++){
9            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
10                ans[st.peek()]=ans[st.peek()]-nums[i];
11                st.pop();
12            }
13            st.push(i);
14        }
15        return ans;
16    }
17}