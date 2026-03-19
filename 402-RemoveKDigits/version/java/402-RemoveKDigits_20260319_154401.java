// Last updated: 19/03/2026, 15:44:01
1class Solution {
2    public String removeKdigits(String num, int k) {
3
4        if(num.length() <= k) return "0";
5
6        char[] arr = num.toCharArray();
7        ArrayDeque<Character> st = new ArrayDeque<>();
8
9        for(int i = 0; i < arr.length; i++){
10
11            while(!st.isEmpty() && st.peek() > arr[i] && k > 0){
12                st.pop();
13                k--;
14            }
15
16            st.push(arr[i]);
17        }
18
19        // If k still remains → remove from end
20        while(k > 0){
21            st.pop();
22            k--;
23        }
24
25        StringBuilder sb = new StringBuilder();
26
27        while(!st.isEmpty()){
28            sb.append(st.pop());
29        }
30
31        // 1️⃣ reverse
32        sb.reverse();
33
34        // 2️⃣ remove leading zeros
35        int i = 0;
36        while(i < sb.length() && sb.charAt(i) == '0'){
37            i++;
38        }
39
40        String result = sb.substring(i);
41
42        // 3️⃣ handle empty case
43        if(result.length() == 0) return "0";
44
45        return result;
46    }
47}