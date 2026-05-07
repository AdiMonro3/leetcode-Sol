// Last updated: 07/05/2026, 21:56:37
1
2class RecentCounter {
3    Queue<Integer> q;
4
5    public RecentCounter() {
6        q = new LinkedList<>();
7    }
8    
9    public int ping(int t) {
10        q.offer(t);  // add current request
11        
12        // remove old requests
13        while (!q.isEmpty() && q.peek() < t - 3000) {
14            q.poll();
15        }
16        
17        return q.size();
18    }
19}
20/**
21 * Your RecentCounter object will be instantiated and called as such:
22 * RecentCounter obj = new RecentCounter();
23 * int param_1 = obj.ping(t);
24 */