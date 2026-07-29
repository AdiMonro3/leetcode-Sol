// Last updated: 29/07/2026, 20:36:31
1class Solution {
2    class Pair{
3        int val;
4        int idx;
5
6        public Pair(int val,int idx){
7            this.val=val;
8            this.idx=idx;
9        }
10    }
11    public int constrainedSubsetSum(int[] nums, int k) {
12        int n=nums.length;
13
14        Queue<Pair> pq=new PriorityQueue<>((a, b)-> Integer.compare(b.val ,a.val));
15        int[] arr=nums.clone();
16        int result=nums[0];
17
18        pq.add(new Pair(nums[0],0));
19        for(int i=1;i<n;i++){
20            while(!pq.isEmpty() && i - pq.peek().idx>k){
21                pq.poll();
22            }
23            arr[i]=Math.max(arr[i],nums[i]+pq.peek().val);
24            result=Math.max(result,arr[i]);
25            pq.add(new Pair(arr[i], i));
26        }
27        return result;
28    }
29}