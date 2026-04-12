// Last updated: 12/04/2026, 10:29:36
1class Solution {
2    boolean[] helper(int n){
3        boolean[] isPrime= new boolean[n+1];
4
5        Arrays.fill(isPrime,true);
6
7        if(n>=0) isPrime[0]=false;
8        if(n>=1) isPrime[1]=false;
9
10        for(int i=2; i*i<=n;i++){
11            if(isPrime[i]){
12                for(int j=i*i; j<=n;j+=i){
13                    isPrime[j]=false;
14                }
15            }
16        }
17        return isPrime;
18    }
19    public int minOperations(int[] nums) {
20
21        boolean[] isPrime=helper(200000);
22
23        int[] nextPrime=new int[200000+1];
24        int next=-1;
25
26        for(int i=200000;i>=0;i--){
27            if(isPrime[i]) next=i;
28            nextPrime[i]=next;
29        }
30
31        int nextNonPrime[]=new int[200000+1];
32        next=-1;
33
34        for(int i=200000;i>=0;i--){
35            if(!isPrime[i]) next=i;
36            nextNonPrime[i]=next;
37        }
38
39        int ops=0;
40
41        for(int i=0;i<nums.length;i++){
42            int val=nums[i];
43
44            if(i%2==0){
45                if(!isPrime[val]){
46                    ops+=(nextPrime[val]-val);
47                }
48            }else{
49                if(isPrime[val]){
50                    ops+=(nextNonPrime[val]-val);
51                }
52            }
53        }
54        return ops;
55        
56    }
57}