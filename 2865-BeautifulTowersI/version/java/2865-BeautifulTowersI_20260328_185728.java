// Last updated: 28/03/2026, 18:57:28
1class Solution {
2    public long maximumSumOfHeights(int[] nums) {
3        int n=nums.length;
4
5        int[] prefix=new int[n];
6        int[] suffix=new int[n];
7
8        ArrayDeque<Integer> st=new ArrayDeque<>();
9
10        for(int i=0;i<n;i++){
11            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
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
23            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
24                st.pop();
25            }
26            if(st.isEmpty()){
27                suffix[i]=n;
28            }else{
29                suffix[i]=st.peek();
30            }
31            st.push(i);
32        }
33
34        System.out.println(Arrays.toString(prefix));
35        System.out.println(Arrays.toString(suffix));
36    
37        System.out.println();
38
39        long [] leftSum=new long[n];
40        long [] rightSum=new long[n];
41
42        for(int i=0;i<n;i++){
43            int prev = prefix[i];
44            long left = (long) nums[i] * (i - prev);
45
46            if (prev == -1) {
47                leftSum[i] = left;
48            } else {
49                leftSum[i] = left + leftSum[prev];
50            }
51        }
52
53        // RIGHT PASS
54        for (int i = n - 1; i >= 0; i--) {
55            int next = suffix[i];
56            long right = (long) nums[i] * (next - i);
57
58            if (next == n) {
59                rightSum[i] = right;
60            } else {
61                rightSum[i] = right + rightSum[next];
62            }
63        }
64        System.out.println(Arrays.toString(leftSum));
65        System.out.println(Arrays.toString(rightSum));
66        
67        long ans=0;
68        for(int i=0;i<n;i++){
69            ans=Math.max(ans,leftSum[i]+rightSum[i]-nums[i]);
70        }
71
72        return ans;
73        
74
75    }
76}