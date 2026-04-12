// Last updated: 12/04/2026, 13:07:33
1class Solution {
2    int n;
3    int nums1[];
4    int nums2[];
5    int dp[][];
6    public boolean conflict(int a1,int a2, int b1, int b2){
7        if(a1>=b1 || a2>=b2) return true;
8
9        return false;
10    }
11    public int helper(int isSwap,int i){
12        if(i>=n) return 0;
13
14        if(dp[i][isSwap]!=-1) return dp[i][isSwap];
15
16        int swap = Integer.MAX_VALUE;
17        int notswap = Integer.MAX_VALUE;
18
19        if(i==0){
20            swap=1+helper(1,i+1);
21            notswap=helper(0,i+1);
22        }else{
23            if(isSwap==1){
24                int prev1=nums2[i-1];
25                int prev2=nums1[i-1];
26                // check NOT swap
27                if (nums1[i] > prev1 && nums2[i] > prev2) {
28                    notswap = helper(0, i + 1);
29                }
30
31                // check swap
32                if (nums2[i] > prev1 && nums1[i] > prev2) {
33                    swap = 1 + helper(1, i + 1);
34                }
35            }else{
36                int prev1=nums1[i-1];
37                int prev2=nums2[i-1];
38                // check NOT swap
39                if (nums1[i] > prev1 && nums2[i] > prev2) {
40                    notswap = helper(0, i + 1);
41                }
42
43                // check swap
44                if (nums2[i] > prev1 && nums1[i] > prev2) {
45                    swap = 1 + helper(1, i + 1);
46                }
47            }
48        }
49
50        return dp[i][isSwap]=Math.min(swap,notswap);
51
52    }
53    public int minSwap(int[] nums1, int[] nums2) {
54        n=nums1.length;
55        this.nums1=nums1;
56        this.nums2=nums2;
57
58        dp=new int[n][2];
59        for(int i=0;i<n;i++){
60            Arrays.fill(dp[i],-1);
61        }
62
63        int swaps=helper(0,0);
64
65        return swaps;
66        
67    }
68}