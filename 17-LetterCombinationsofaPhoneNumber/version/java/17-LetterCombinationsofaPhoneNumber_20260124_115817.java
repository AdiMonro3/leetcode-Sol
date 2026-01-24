// Last updated: 24/01/2026, 11:58:17
1class Solution {
2    List<String> result=new ArrayList<>();
3    public void helper(String digits,String[] map,int i,StringBuilder sb){
4        if(sb.length()==digits.length()){
5            String s=sb.toString();
6            result.add(s);
7            return;
8        }
9        int digit=digits.charAt(i)-'0';
10        String ss=map[digit];
11        for(int j=0;j<ss.length();j++){
12            char c=ss.charAt(j);
13            sb.append(c);
14            helper(digits,map,i+1,sb);
15            sb.deleteCharAt(sb.length() - 1);
16        }
17    }
18    public List<String> letterCombinations(String digits) {
19        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
20        StringBuilder sb=new StringBuilder();
21        helper(digits,map,0,sb);
22
23        return result;
24
25        
26    }
27}