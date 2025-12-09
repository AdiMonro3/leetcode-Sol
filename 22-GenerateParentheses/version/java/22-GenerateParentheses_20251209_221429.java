// Last updated: 09/12/2025, 22:14:29
1class Solution {
2    public static ArrayList<String> result= new ArrayList<>();
3    public static void generate(int n,String s,int open,int close){
4        if(s.length()==2*n){
5            result.add(s);
6            return;
7        }
8         if (open < n) {
9            generate(n, s + "(", open + 1, close);
10        }
11        if (close < open) {
12            generate(n, s + ")", open, close + 1);
13        }
14
15    }
16    public List<String> generateParenthesis(int n) {
17            result.clear();
18            generate(n,"",0,0);
19
20            return result;
21        
22    }
23}