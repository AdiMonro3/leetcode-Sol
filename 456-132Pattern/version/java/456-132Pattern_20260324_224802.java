// Last updated: 24/03/2026, 22:48:02
1class Solution {
2    public boolean find132pattern(int[] nums) {
3        int n=nums.length;
4        ArrayDeque<Integer> st=new ArrayDeque<>();
5
6        int num3=Integer.MIN_VALUE;
7        for(int i=n-1;i>=0;i--){
8            if(nums[i]<num3) return true;
9
10            while(!st.isEmpty() && st.peek()<nums[i]){
11                num3=Math.max(num3,st.pop());
12            }
13
14
15            st.push(nums[i]);
16        }
17        return false;
18    }
19}