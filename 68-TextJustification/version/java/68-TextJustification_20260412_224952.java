// Last updated: 12/04/2026, 22:49:52
1class Solution {
2    public List<String> fullJustify(String[] words, int max) {
3        int n=words.length;
4
5        int i=0;
6        List<String> lst=new ArrayList<String>();
7
8        while(i<n){
9
10            int count=0;
11            int idx=-1;
12            int charCount=0;
13
14            for(int j=i;j<n;j++){
15
16                count+=words[j].length()+1;
17                if(count-1>max){
18                    count-=words[j].length()-2;
19                    break;
20                }
21                charCount+=words[j].length();
22                idx=j;
23            }
24            int totalspaces=max-charCount;
25            int gaps=idx-i;
26            System.out.println(totalspaces+" "+gaps);
27
28            
29
30            StringBuilder sb=new StringBuilder();
31
32            if(idx==n-1 || gaps==0){
33                for(int j=i;j<=idx;j++){
34                    sb.append(words[j]);
35                    if (j != idx) sb.append(" ");
36                }
37                while(sb.length()<max) sb.append(" ");
38
39                lst.add(sb.toString());
40
41            }else{
42
43                int base = totalspaces / gaps;
44                int extra = totalspaces % gaps;
45
46
47                for(int j=i;j<idx;j++){
48                    
49                    int spaces = base + ((j-i) < extra ? 1 : 0);
50
51                    sb.append(words[j]);
52
53                    for(int k=0;k<spaces;k++){
54                        sb.append(" ");
55                    }
56                }
57                sb.append(words[idx]);
58                lst.add(sb.toString());
59            }
60
61            i=idx+1;
62        }
63        return lst;
64    }
65}