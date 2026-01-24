// Last updated: 24/01/2026, 12:50:49
1class Solution {
2    public int charDiff(String s1,String s2){
3        int count=0;
4        for(int i=0;i<s1.length();i++){
5            if(s1.charAt(i)!=s2.charAt(i)){
6                count++;
7            }
8        }
9        return count;
10    }
11    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
12        Queue<String> q=new ArrayDeque<>();
13        int n=wordList.size();
14        int result=0;
15        boolean visited[]=new boolean[n];
16        q.add(beginWord);
17        while(!q.isEmpty()){
18            int size=q.size();
19            result++;
20            while(size>0){
21            String s=q.poll();
22            if(endWord.equals(s)) return result;
23            for(int i=0;i<n;i++){
24                String t=wordList.get(i);
25                if(!visited[i] && charDiff(s,t)==1){
26                    visited[i]=true;
27                    q.add(t);
28                }
29            }
30            size--;
31        }
32
33        }
34        return 0;
35    }
36}