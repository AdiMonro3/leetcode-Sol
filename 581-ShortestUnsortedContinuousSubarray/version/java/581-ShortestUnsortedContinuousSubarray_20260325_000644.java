// Last updated: 25/03/2026, 00:06:44
1class Solution {
2    public int findUnsortedSubarray(int[] nums) {
3        int n=nums.length;
4        ArrayDeque<Integer> sl=new ArrayDeque<>();
5
6        int l=n+1;
7        int r=-1;
8
9        for(int i=0;i<n;i++){
10            while(!sl.isEmpty() && nums[sl.peek()]>nums[i]){
11                l=Math.min(l,sl.peek());
12                sl.pop();
13            }
14            sl.push(i);
15        }
16        ArrayDeque<Integer> sr=new ArrayDeque<>();
17        for(int i=n-1;i>=0;i--){
18            while(!sr.isEmpty() && nums[sr.peek()]<nums[i]){
19                r=Math.max(r,sr.peek());
20                System.out.println(sr.pop());
21            }
22            sr.push(i);
23        }
24        System.out.print(l+" "+r);
25
26        if(l==n+1 && r==-1) return 0;
27
28        return r-l+1;
29
30    }
31}