// Last updated: 06/08/2026, 19:52:22
1class Solution {
2    public String shortestPalindrome(String s) {
3        int n=s.length();
4        StringBuilder t=new StringBuilder();
5        t.append('#'); 
6        
7        for(int i=0;i<n;i++){
8            t.append(s.charAt(i));
9            t.append('#');
10        }
11        int m=t.length();
12        int[] p=new int[m];// track length 
13        p[0]=0;
14
15        int l=0; // track left boundry of rightmost palindrom found so far
16        int r=0; // track right boundry of rightmost palindrom found so far
17
18        int center=0 ;// track center index of longest palindrom
19        int maxLen=0; // track length of longest plaindrom
20
21        for(int i=0;i<m;i++){
22            int k;
23
24            if(i>r){
25                k=0;
26            }else{
27                int j=l+(r-i);
28                if(j-p[j]>l){
29                    p[i]=p[j];
30                    continue;
31                }else{
32                    k=r-i;
33                }
34            }
35
36            while(i-k>=0 && i+k<m && t.charAt(i-k)==t.charAt(i+k)){
37                k++;
38            }
39            k--;
40
41            p[i]=k;
42            if(p[i]>maxLen){
43                if((i-p[i])/2==0){
44                    maxLen=p[i];
45                    center=i;    
46                }
47                
48            }
49            if(i+k>r){
50                l=i-k;
51                r=i+k;
52            }
53        }
54        StringBuilder result=new StringBuilder();
55        for(int i=n-1;i>=(center+maxLen)/2;i--){
56            result.append(s.charAt(i));
57        }
58        result.append(s);
59
60        return result.toString();
61
62    }
63}