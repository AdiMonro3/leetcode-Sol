// Last updated: 14/03/2026, 15:01:14
1class Solution {
2    public String removeDuplicateLetters(String s) {
3        int n = s.length();
4
5        int[] freq = new int[26];
6        boolean[] visited = new boolean[26];
7        ArrayDeque<Character> st = new ArrayDeque<>();
8
9        for(int i = 0; i < n; i++){
10            freq[s.charAt(i)-'a']++;
11        }
12
13        for(char ch: s.toCharArray()){
14
15            freq[ch-'a']--;
16            if(visited[ch-'a']) continue;
17
18            while(!st.isEmpty() && st.peek() > ch && freq[st.peek()-'a'] != 0){
19                char c=st.pop();
20                visited[c-'a']=false;
21                System.out.println(c+" popped");
22
23            }
24            if(!visited[ch-'a']){
25                st.push(ch);
26                visited[ch-'a']=true;
27                System.out.println(ch+" pushed ");
28            }
29        }
30         StringBuilder result = new StringBuilder();
31        for(char c : st) {
32            System.out.print(c+" ");
33            result.append(c);
34        }
35
36        String reversed = result.reverse().toString();
37
38        return reversed;
39    }
40}