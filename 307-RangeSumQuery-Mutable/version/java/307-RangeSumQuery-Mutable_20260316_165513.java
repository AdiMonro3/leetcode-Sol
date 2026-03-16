// Last updated: 16/03/2026, 16:55:13
1class NumArray {
2    int arr[];
3    int tree[];
4    int n;
5    public NumArray(int[] nums) {
6        n=nums.length;
7        arr=new int[n];
8        tree=new int[4*n];
9        arr=nums;
10
11        build(1,0,n-1);
12    }
13    public void build(int node,int l,int r){
14        if(l==r) {
15            tree[node]=arr[l];
16            return;
17        }
18        
19        int mid=(l+r)/2;
20
21        build(node*2, l, mid);
22        build(node*2+1, mid+1, r);
23
24        tree[node]=tree[node*2]+tree[node*2+1];
25    }
26    public int query(int node,int l,int r,int ql,int qr){
27        if(r < ql || l > qr)
28            return 0;
29
30        if(ql <= l && r <= qr)
31            return tree[node];
32
33        int mid = (l+r)/2;
34
35        int left = query(node*2,l,mid,ql,qr);
36        int right = query(node*2+1,mid+1,r,ql,qr);
37
38        return left + right;
39    }
40    public void updateRange(int node ,int l,int r,int idx){
41        if(l==r){
42            tree[node]=arr[idx];
43            return;
44        }
45        int mid=(l+r)/2;
46
47        if(idx<=mid){
48            updateRange(node*2,l,mid,idx);
49        }else{
50            updateRange(node*2+1,mid+1,r,idx);
51        }
52
53        tree[node]=tree[node*2]+tree[node*2+1];
54    }
55    public void update(int index, int val) {
56        arr[index]=val;
57        updateRange(1,0,n-1,index);
58    }
59    
60    public int sumRange(int left, int right) {
61        return query(1,0,n-1,left,right);
62    }
63}
64
65/**
66 * Your NumArray object will be instantiated and called as such:
67 * NumArray obj = new NumArray(nums);
68 * obj.update(index,val);
69 * int param_2 = obj.sumRange(left,right);
70 */