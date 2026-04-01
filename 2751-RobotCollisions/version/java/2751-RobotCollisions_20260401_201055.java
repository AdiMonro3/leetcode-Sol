// Last updated: 01/04/2026, 20:10:55
1class Solution {
2    class Pair{
3        int val;
4        int idx;
5
6        Pair(int val,int idx){
7            this.val=val;
8            this.idx=idx;
9        }
10    }
11    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String s) {
12       int n=positions.length;
13       PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.val-b.val);
14
15       for(int i=0;i<n;i++){
16            pq.add(new Pair(positions[i],i));
17       }
18
19        ArrayDeque<Integer> st=new ArrayDeque<>();
20
21        while(!pq.isEmpty()){
22            Pair p=pq.poll();
23
24            int idx=p.idx;
25            while (!st.isEmpty() && s.charAt(st.peek()) == 'R' && s.charAt(idx) == 'L') {
26                if (healths[st.peek()] < healths[idx]) {
27                    healths[idx]--;
28                    st.pop();
29                } else if (healths[st.peek()] > healths[idx]) {
30                    healths[st.peek()]--;
31                    healths[idx] = 0;
32                    break;
33                } else {
34                    healths[idx] = 0;
35                    st.pop();
36                    break;
37                }
38            }
39
40            if (healths[idx] > 0) {
41                st.push(idx);
42            }
43        }
44        List<Integer> ans = new ArrayList<>();
45        List<Integer> temp = new ArrayList<>(st);
46
47        Collections.sort(temp);
48
49        for (int i : temp) {
50            ans.add(healths[i]);
51        }
52
53        return ans;
54    }
55}