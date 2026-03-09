// Last updated: 09/03/2026, 13:11:21
1class Solution {
2    public int evalRPN(String[] tokens) {
3        Deque<Integer> st=new ArrayDeque<>();
4
5        for(int i=0;i<tokens.length;i++){
6            if(tokens[i].equals("+")){
7                int first=st.pop();
8                int second=st.pop();
9
10                int ans=second+first;
11                st.push(ans);
12            }
13            else if(tokens[i].equals("-")){
14                int first=st.pop();
15                int second=st.pop();
16
17                int ans=second-first;
18                st.push(ans);
19            }
20            else if(tokens[i].equals("/")){
21                int first=st.pop();
22                int second=st.pop();
23
24                int ans=second/first;
25                st.push(ans);
26            }
27            else if(tokens[i].equals("*")){
28                int first=st.pop();
29                int second=st.pop();
30
31                int ans=second*first;
32                st.push(ans);
33            }
34            else{
35                int num = Integer.parseInt(tokens[i]);
36                st.push(num);
37            }
38        }
39        int ans=st.pop();
40
41        return ans;
42    }
43}