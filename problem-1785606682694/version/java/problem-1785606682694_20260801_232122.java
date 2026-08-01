// Last updated: 01/08/2026, 23:21:22
1class Solution {
2    public int maximumWidth(int[] planks) {
3        Map<Integer,Integer> freq=new HashMap<>();
4
5        for(int p:planks) freq.merge(p,1,Integer::sum);
6
7        int m=freq.size();
8
9        int[] vals=new int[m];
10        int[] cnt=new int[m];
11
12        int idx=0;
13        for(Map.Entry<Integer,Integer> e:freq.entrySet()){
14            vals[idx]=e.getKey();
15            cnt[idx]=e.getValue();
16            idx++;
17        }
18        HashMap<Long,Integer> pair=new HashMap<>();
19        int best=0;
20
21        for(int i=0;i<m;i++){
22            best=Math.max(best,cnt[i]);
23            if(cnt[i]>=2){
24                pair.merge(2L*vals[i],cnt[i]/2,Integer::sum);
25            }
26            for(int j=i+1;j<m;j++){
27                pair.merge((long) vals[i]+vals[j],Math.min(cnt[i],cnt[j]),Integer::sum);
28            }
29        }
30
31        for(Map.Entry<Long,Integer> e:pair.entrySet()){
32            long h=e.getKey();
33            int w=e.getValue();
34            if(h<=Integer.MAX_VALUE){
35                Integer c=freq.get((int) h);
36                if(c!=null) w+=c;
37            }
38            best=Math.max(best,w);
39        }
40        return best;
41    }
42}