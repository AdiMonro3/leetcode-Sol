// Last updated: 28/03/2026, 19:03:16
1class Solution {
2    public long maximumSumOfHeights(List<Integer> nums) {
3        int n=nums.size();
4
5        int[] prefix=new int[n];
6        int[] suffix=new int[n];
7
8        ArrayDeque<Integer> st=new ArrayDeque<>();
9
10        for(int i=0;i<n;i++){
11            while(!st.isEmpty() && nums.get(st.peek())>=nums.get(i)){
12                st.pop();
13            }
14            if(st.isEmpty()){
15                prefix[i]=-1;
16            }else{
17                prefix[i]=st.peek();
18            }
19            st.push(i);
20        }
21        st.clear();
22        for(int i=n-1;i>=0;i--){
23            while(!st.isEmpty() && nums.get(st.peek())>nums.get(i)){
24                st.pop();
25            }
26            if(st.isEmpty()){
27                suffix[i]=n;
28            }else{
29                suffix[i]=st.peek();
30            }
31            st.push(i);
32        }
33        long [] leftSum=new long[n];
34        long [] rightSum=new long[n];
35
36        for(int i=0;i<n;i++){
37            int prev = prefix[i];
38            long left = (long) nums.get(i) * (i - prev);
39
40            if (prev == -1) {
41                leftSum[i] = left;
42            } else {
43                leftSum[i] = left + leftSum[prev];
44            }
45        }
46
47        // RIGHT PASS
48        for (int i = n - 1; i >= 0; i--) {
49            int next = suffix[i];
50            long right = (long) nums.get(i) * (next - i);
51
52            if (next == n) {
53                rightSum[i] = right;
54            } else {
55                rightSum[i] = right + rightSum[next];
56            }
57        }
58
59        long ans=0;
60        for(int i=0;i<n;i++){
61            ans=Math.max(ans,leftSum[i]+rightSum[i]-nums.get(i));
62        }
63
64        return ans;
65        
66
67    }
68}