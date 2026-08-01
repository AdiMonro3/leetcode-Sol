// Last updated: 01/08/2026, 23:22:01
1class Solution {
2    public int minMaxWaitingTime(int[] demand, int[] fuel) {
3        int n=demand.length;
4
5        final int MB=21;
6        final int W0=fuel[0]+1;
7        final int W1=fuel[1]+1;
8        final int SIZE=W0*W1*MB*MB;
9
10        int[] cur=new int[SIZE];
11        int[] nxt=new int[SIZE];
12        Arrays.fill(cur,-1);
13        Arrays.fill(nxt,-1);
14
15        int[] curList=new int[SIZE];
16        int[] nxtList=new int[SIZE];
17
18        int curLen=0;
19
20        int startId=((fuel[0]*W1+fuel[1])*MB)*MB;
21
22        cur[startId]=0;
23        curList[curLen++]=startId;
24
25        int bestServed=0;
26        int bestWait=Integer.MAX_VALUE;
27
28        for(int i=0;i<n;i++){
29            int d=demand[i];
30            int nxtLen=0;
31
32            for(int t=0;t<curLen;t++){
33                int id=curList[t];
34                int maxW=cur[id];
35                cur[id]=-1;
36
37                int b1=id%MB;
38                int r=id/MB;
39                int b0=r%MB;
40                    r/=MB;
41                int f1=r%W1;
42                int f0=r/W1;
43
44                boolean ok0=f0>=d;
45                boolean ok1=f1>=d;
46
47                if(!ok0 && !ok1){
48                    if(i>bestServed){
49                        bestServed = i; bestWait = maxW;
50                    }else if (i == bestServed && maxW < bestWait) bestWait = maxW;
51                    continue;
52                }
53                if (ok0) {                      // queue on dispenser 0, wait out b0
54                    int nw  = Math.max(maxW, b0);
55                    int nid = (((f0 - d) * W1 + f1) * MB + d) * MB + Math.max(0, b1 - b0);
56                    if (nxt[nid] == -1) { nxt[nid] = nw; nxtList[nxtLen++] = nid; }
57                    else if (nw < nxt[nid]) nxt[nid] = nw;
58                }
59                if (ok1) {                      // queue on dispenser 1, wait out b1
60                    int nw  = Math.max(maxW, b1);
61                    int nid = ((f0 * W1 + (f1 - d)) * MB + Math.max(0, b0 - b1)) * MB + d;
62                    if (nxt[nid] == -1) { nxt[nid] = nw; nxtList[nxtLen++] = nid; }
63                    else if (nw < nxt[nid]) nxt[nid] = nw;
64                }
65            }
66            int[] ta = cur; cur = nxt; nxt = ta;
67            int[] tl = curList; curList = nxtList; nxtList = tl;
68            curLen = nxtLen;
69            if (curLen == 0) break;
70        }
71
72        for (int t = 0; t < curLen; t++) {
73            int maxW = cur[curList[t]];
74            if (n > bestServed) { bestServed = n; bestWait = maxW; }
75            else if (n == bestServed && maxW < bestWait) bestWait = maxW;
76        }
77        return bestServed == 0 ? -1 : bestWait;
78    }
79    
80}