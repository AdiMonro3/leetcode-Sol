// Last updated: 13/03/2026, 13:33:53
1class StockSpanner {
2    class Pair{
3        int val;
4        int idx;
5
6        public Pair(int val,int idx){
7            this.val=val;
8            this.idx=idx;
9        }
10
11    }
12    Stack<Pair> st;
13    int index=0;
14    public StockSpanner() {
15        st=new Stack<>();
16    }
17    
18    public int next(int price) {
19        int ans=0;
20        index++;
21        while(!st.isEmpty() && st.peek().val<=price){
22            st.pop();
23        }
24
25        if(st.isEmpty()) ans= index-0;
26        else ans=index-st.peek().idx;
27
28        st.push(new Pair(price,index));
29
30        return ans;
31    }
32}
33
34/**
35 * Your StockSpanner object will be instantiated and called as such:
36 * StockSpanner obj = new StockSpanner();
37 * int param_1 = obj.next(price);
38 */