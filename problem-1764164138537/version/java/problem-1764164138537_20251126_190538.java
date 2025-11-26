// Last updated: 26/11/2025, 19:05:38
1class Solution {
2    List<String> result=new ArrayList<>();
3    public List<String> helper(String s,int n,List<String> wordDict,StringBuilder temp,int start){
4        if(start>=n){
5            result.add(temp.toString());
6        }
7        for(int end=start+1;end<=n;end++){
8            String st=s.substring(start,end);
9            if(wordDict.contains(st)){
10                int currentLen = temp.length();
11
12                if (currentLen != 0) temp.append(" ");
13                temp.append(st);
14                helper(s,n,wordDict,temp,end);
15                temp.setLength(currentLen);
16            }
17        }
18        return result;
19    }
20    public List<String> wordBreak(String s, List<String> wordDict) {
21        StringBuilder temp=new StringBuilder();
22        return helper(s,s.length(),wordDict,temp,0);
23    }
24}