// Last updated: 11/03/2026, 12:53:09
1class Solution {
2    public int minFlips(String s) {
3        int n=s.length();
4
5        int[] pt1=new int[2*n];
6        int[] pt2=new int[2*n];
7
8        for(int i = 0; i < 2*n; i++){
9            pt1[i] = i % 2;
10            pt2[i] = 1 - (i % 2);
11        }
12        int ans1=0;
13        int ans2=0;
14
15        int min=Integer.MAX_VALUE;
16
17        int i=0;
18        int j=0;
19        while(j<2*n){
20            
21            if(s.charAt(j%n)-'0'!=pt1[j]){
22                ans1++;
23            }
24            if(s.charAt(j%n)-'0'!=pt2[j]){
25                ans2++;
26            }
27
28            if(j-i>=s.length()){
29                if(s.charAt(i%n)-'0'!=pt1[i]){
30                    ans1--;
31                }
32                if(s.charAt(i%n)-'0'!=pt2[i]){
33                    ans2--;
34                }
35                i++;
36            }
37            
38            if(j-i==s.length()-1){
39                min=Math.min(min,Math.min(ans1,ans2));
40            }
41            j++;
42        }
43        return min;
44        
45    }
46}