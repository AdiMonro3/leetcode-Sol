// Last updated: 13/03/2026, 14:14:54
1class Solution {
2    public String removeDuplicates(String s) {
3        Stack<Character> stack = new Stack<>();
4
5        for(char c : s.toCharArray()) {
6
7            if(!stack.isEmpty() && stack.peek() == c) {
8                stack.pop();
9            } 
10            else {
11                stack.push(c);
12            }
13
14        }
15
16        StringBuilder result = new StringBuilder();
17
18        for(char c : stack) {
19            result.append(c);
20        }
21
22        return result.toString();
23    }
24}