// Last updated: 13/03/2026, 13:54:17
1class Solution {
2    public int[] dailyTemperatures(int[] arr) {
3        int n=arr.length;
4        int[] ans=new int[n];
5        Stack<Integer> st=new Stack<>();
6
7        for(int i=n-1;i>=0;i--){
8            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
9                st.pop();
10            }
11
12            if(st.isEmpty()) ans[i]=0;
13            else ans[i]=st.peek()-i;
14
15            st.push(i);
16        }
17        return ans;
18    }
19}