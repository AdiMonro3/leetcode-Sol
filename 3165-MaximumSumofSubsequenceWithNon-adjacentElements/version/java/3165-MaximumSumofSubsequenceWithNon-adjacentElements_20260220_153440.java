// Last updated: 20/02/2026, 15:34:40
1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3        ArrayDeque<Integer> q = new ArrayDeque<>(); 
4        int i=0, j=0, ptr=0; 
5        int n = nums.length; 
6        int[] res = new int[n-k+1]; 
7
8        while(j<n){
9            while(!q.isEmpty() && q.peekLast()<nums[j]){
10                q.pollLast(); 
11            }
12        
13            q.add(nums[j]);
14
15            if(j-i+1<k){
16                j++; 
17            }else if(j-i+1==k){
18
19                res[ptr++] = q.peek();
20                
21                if(nums[i]==q.peek()){
22                    q.pollFirst(); 
23                }
24                i++; 
25                j++;
26            }
27        }
28
29        return res; 
30       
31    }
32}