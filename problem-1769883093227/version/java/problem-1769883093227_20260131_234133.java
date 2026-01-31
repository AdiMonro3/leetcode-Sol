// Last updated: 31/01/2026, 23:41:33
1class Solution {
2    public String reverseByType(String s) {
3         List<Character> letter=new ArrayList<>();
4        List<Character> sc=new ArrayList<>();
5
6        for(int i=0;i<s.length();i++){
7            char c=s.charAt(i);
8            if(c>='a' && c<='z'){
9                letter.add(c);
10            }else{
11                sc.add(c);
12            }
13        }
14            Collections.reverse(letter);
15            Collections.reverse(sc);
16
17            StringBuilder sb=new StringBuilder();
18
19            int i=0;
20            int j=0;
21        for(int k=0;k<s.length();k++){
22            char ch=s.charAt(k);
23            if(ch>='a' && ch<='z'){
24                sb.append(letter.get(i));
25                i++;
26            }else{
27                sb.append(sc.get(j));
28                j++;
29            }
30        }
31            return sb.toString();
32    }
33}