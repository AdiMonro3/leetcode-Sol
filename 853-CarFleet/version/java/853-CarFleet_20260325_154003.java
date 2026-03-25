// Last updated: 25/03/2026, 15:40:03
1class Solution {
2    class Pair{
3        int val;
4        int speed;
5
6        Pair(int val,int speed){
7            this.val=val;
8            this.speed=speed;
9        }
10    }
11    public int carFleet(int target, int[] position, int[] speed) {
12        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.val-a.val);
13
14        for(int i=0;i<position.length;i++){
15            int pos=position[i];
16            int sped=speed[i];
17
18            pq.add(new Pair(pos,sped));
19        }
20
21        int idx=0;
22        while(!pq.isEmpty()){
23            
24            Pair p=pq.poll();
25
26            int pos=p.val;
27            int sped=p.speed;
28
29            position[idx]=pos;
30            speed[idx]=sped;
31
32            idx++;
33        }
34
35        ArrayDeque<Double> st=new ArrayDeque<>();
36
37        for(int i=0;i<position.length;i++){
38            double at=(double)(target-position[i])/speed[i];
39            System.out.print(at+" ");
40            double prevSpd=Integer.MIN_VALUE;
41            boolean poppedonce=false;
42            while(!st.isEmpty() && st.peek()>=at && !poppedonce){
43
44                prevSpd=st.pop();
45                poppedonce=true;
46            }
47
48            st.push(Math.max(prevSpd,at));
49        }
50       System.out.print(Arrays.toString(position));
51       System.out.print(Arrays.toString(speed));
52        return st.size();
53    }
54}