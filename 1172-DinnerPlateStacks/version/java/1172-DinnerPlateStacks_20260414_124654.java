// Last updated: 14/04/2026, 12:46:54
1class DinnerPlates {
2    List<Stack<Integer>> stacks;
3    PriorityQueue<Integer> pq; // stores indices of stacks with space
4    int capacity;
5
6    public DinnerPlates(int capacity) {
7        this.capacity = capacity;
8        stacks = new ArrayList<>();
9        pq = new PriorityQueue<>();
10    }
11    
12    public void push(int val) {
13       // remove indices that are out of bounds
14        while (!pq.isEmpty() && pq.peek() >= stacks.size()) {
15            pq.poll();
16        }
17
18        // remove full stacks
19        while (!pq.isEmpty() && stacks.get(pq.peek()).size() == capacity) {
20            pq.poll();
21        }
22
23        if (!pq.isEmpty()) {
24            int idx = pq.poll();
25            stacks.get(idx).push(val);
26
27            // if still has space, add back
28            if (stacks.get(idx).size() < capacity) {
29                pq.offer(idx);
30            }
31        } else {
32            Stack<Integer> st = new Stack<>();
33            st.push(val);
34            stacks.add(st);
35
36            if (capacity > 1) {
37                pq.offer(stacks.size() - 1);
38            }
39        }
40    }
41    
42    public int pop() {
43        // remove empty stacks from right
44        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
45            stacks.remove(stacks.size() - 1);
46        }
47
48        if (stacks.isEmpty()) return -1;
49
50        int idx = stacks.size() - 1;
51        int val = stacks.get(idx).pop();
52
53        // this stack now has space → add to pq
54        pq.offer(idx);
55
56        return val;
57    }
58    
59    public int popAtStack(int index) {
60        if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty()) {
61            return -1;
62        }
63
64        int val = stacks.get(index).pop();
65
66        // this stack now has space → add to pq
67        pq.offer(index);
68
69        return val;
70    }
71}