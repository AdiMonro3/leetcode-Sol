// Last updated: 16/03/2026, 16:13:48
1class Solution {
2    int[] tree;
3    int n;
4    public void build(int node,int l,int r,int[] baskets){
5        if(l==r){
6            tree[node]=baskets[l];
7            return;
8        }
9
10        int mid=(l+r)/2;
11        build(node*2,l,mid,baskets);
12        build(node*2+1,mid+1,r,baskets);
13
14        tree[node]=Math.max(tree[node*2],tree[node*2+1]);
15    }
16
17    public int query(int node,int l,int r,int val){
18        if(tree[node]<val) return -1;
19
20        if(l==r) return l;
21
22        int mid=(l+r)/2;
23        if(tree[node*2]>=val){
24            return query(node*2,l,mid,val);
25        }
26        return query(node*2+1,mid+1,r,val);
27    }
28
29    public void update(int node,int l,int r,int idx){
30        if(l==r){
31            tree[node]=0;
32            return;
33        }
34
35        int mid=(l+r)/2;
36
37        if(idx<=mid){
38            update(node*2,l,mid,idx);
39        }else{
40            update(node*2+1,mid+1,r,idx);
41        }
42
43        tree[node]=Math.max(tree[node*2],tree[node*2+1]);
44    }
45    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
46        n=baskets.length;
47        tree=new int[4*n];
48
49        build(1,0,n-1,baskets);
50
51        int unplaced = 0;
52
53        for(int f : fruits){
54
55            int idx = query(1,0,n-1,f);
56
57            if(idx == -1)
58                unplaced++;
59            else
60                update(1,0,n-1,idx);
61        }
62
63        return unplaced;
64    }
65}