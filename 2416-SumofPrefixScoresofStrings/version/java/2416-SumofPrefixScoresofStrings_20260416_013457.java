// Last updated: 16/04/2026, 01:34:57
1class TrieNode{
2        TrieNode[] links=new TrieNode[26];
3        boolean flag=false;
4        int count=0;
5
6        boolean containKey(char ch) {
7            return links[ch - 'a'] != null;
8        }
9
10        TrieNode get(char ch){
11            return links[ch-'a'];
12        }
13        
14        void put(char ch , TrieNode newNode){
15            links[ch-'a']=newNode;
16        }
17
18        void inc(char ch){
19            links[ch-'a'].count++;
20        }
21
22        public int retCount(char ch) {
23            return links[ch - 'a'].count;
24        }
25
26        void setEnd() {
27            flag = true;
28        }
29
30        boolean isEnd() {
31            return flag;
32        }
33
34
35    }
36class Solution {
37
38    TrieNode root;
39
40    public Solution(){
41        root=new TrieNode();
42    }
43
44    public void insert(String word) {
45        TrieNode node = root;
46        for (char ch : word.toCharArray()) {
47            if (!node.containKey(ch)) {
48                node.put(ch, new TrieNode());
49            }
50            node.inc(ch);
51            node = node.get(ch);
52        }
53    }
54    public int search(String word) {
55        TrieNode node = root;
56        int preCount = 0;
57        for (char ch : word.toCharArray()) {
58            preCount += node.retCount(ch);
59            node = node.get(ch);
60        }
61        return preCount;
62    }
63    
64    public int[] sumPrefixScores(String[] words) {
65        for (String word : words) {
66            insert(word);
67        }
68        int n = words.length;
69        int[] res = new int[n];
70        for (int i = 0; i < n; i++) {
71            res[i] = search(words[i]);
72        }
73        return res;
74        
75    }
76}