// Last updated: 17/03/2026, 13:35:21
1class NumArray {
2    int[] nums;
3    int[] prefix;
4    int n;
5    public NumArray(int[] nums) {
6        n=nums.length;
7        this.nums=new int[n];
8        prefix=new int[n];
9
10        int sum=0;
11        for(int i=0;i<n;i++){
12            sum+=nums[i];
13            prefix[i]=sum;
14        }
15    }
16    
17
18    public int sumRange(int l, int r) {
19        if(l==0){
20            return prefix[r];
21        }
22        return prefix[r]-prefix[l-1];
23    }
24}
25
26/**
27 * Your NumArray object will be instantiated and called as such:
28 * NumArray obj = new NumArray(nums);
29 * int param_1 = obj.sumRange(left,right);
30 */