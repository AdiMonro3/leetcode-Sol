// Last updated: 25/01/2026, 12:48:59
1class Solution {
2    public void unionByRank(char [] parent,int [] rank,char u,char v){
3        char ulpU=find(parent,u);
4        char ulpV=find(parent,v);
5
6        //if parnet if u and v is same
7        if(ulpU==ulpV) return ;
8        
9        // parent of u and v is not same
10        if(rank[ulpU-'a']> rank[ulpV-'a']){
11            parent[ulpV-'a']=ulpU;
12        }
13        else if(rank[ulpV-'a']>rank[ulpU-'a']){
14            parent[ulpU-'a']=ulpV;
15        }
16        else{
17            parent[ulpV-'a']=ulpU;
18            rank[ulpU-'a']+=1;
19        }
20    }
21    public char find(char[] parent,char u){
22        // return if parent is node of itself
23        if(u==parent[u-'a']) return u;
24
25        char ultimateParent=find(parent,parent[u-'a']);
26
27        parent[u-'a']=ultimateParent;
28
29        return parent[u-'a'];
30    }
31    public boolean equationsPossible(String[] equations) {
32        int [] rank=new int[26];
33        char [] parent=new char[26];
34
35        for(int i=0;i<26;i++){
36            parent[i]=(char)(i+'a');
37        }
38
39        for(String s:equations){
40            char a=s.charAt(0);
41            char b=s.charAt(3);
42            char sign=s.charAt(1);
43
44            if(sign=='='){
45                unionByRank(parent,rank,a,b);
46            }
47        }
48        for(String s:equations){
49            char a=s.charAt(0);
50            char b=s.charAt(3);
51            char sign=s.charAt(1);
52            if(sign=='!'){
53                if(find(parent,a)==find(parent,b)) return false;
54            }
55        }
56        return true;
57    }
58}