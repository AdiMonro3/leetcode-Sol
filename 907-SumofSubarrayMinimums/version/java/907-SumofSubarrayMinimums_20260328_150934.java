// Last updated: 28/03/2026, 15:09:34
1class Solution {
2    int mod = (int)1e9 + 7;
3
4    public int sumSubarrayMins(int[] arr) {
5        int n=arr.length;
6
7        int[] nsl=new int[n];
8        int[] nsr=new int[n];
9
10        ArrayDeque<Integer> st=new ArrayDeque<>();
11
12        for(int i=0;i<n;i++){
13        
14            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
15                st.pop();
16            }
17            if(st.isEmpty()){
18                nsl[i]=-1;
19            }else{
20                nsl[i]=st.peek();
21            }
22            st.push(i);
23        }
24        st.clear();
25        for(int i=n-1;i>=0;i--){
26        
27            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
28                st.pop();
29            }
30            if(st.isEmpty()){
31                nsr[i]=n;
32            }else{
33                nsr[i]=st.peek();
34            }
35            st.push(i);
36        }
37
38        System.out.println(Arrays.toString(nsl));
39        System.out.println(Arrays.toString(nsr));
40
41        long sum=0;
42        for(int i=0;i<n;i++){
43            int l=i-nsl[i]; // length if left side of i excluding i 
44
45            int r= nsr[i]-i; // length of right side of i excluding i
46
47            sum=(sum + ((long)arr[i] * l % mod) * r % mod) % mod;
48        }
49
50        return (int)sum;
51    }
52}