// Last updated: 14/03/2026, 23:36:26
1class Solution {
2    public long gcd(long a,long b){
3        while(b!=0){
4            long temp=b;
5            b=a%b;
6            a=temp;
7        }
8        return a;
9    }
10    public long gcdSum(int[] nums) {
11        int n=nums.length;
12        
13        int [] prefixmax = new int[n];
14        int max = Integer.MIN_VALUE;
15        
16        for(int i = 0; i < n; i++){
17            max = Math.max(max,nums[i]);
18            prefixmax[i] = max;
19        }
20
21        long[] prefixgcd=new long[n];
22        
23        for(int i = 0; i < n; i++){
24            long temp = gcd(prefixmax[i],nums[i]);
25            prefixgcd[i] = temp;
26        }
27
28        Arrays.sort(prefixgcd);
29
30        int i = 0;
31        int j = n-1;
32
33        long ans=0;
34
35        
36        while(i<j){
37            
38            long p1 = prefixgcd[i];
39            long p2 = prefixgcd[j];
40
41            ans += gcd(p1 , p2);
42
43            i++;
44            j--;
45            
46        }
47
48        return ans;
49        
50        
51    }
52}