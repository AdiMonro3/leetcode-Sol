// Last updated: 13/05/2026, 12:37:56
1class Solution {
2    public int uniqueMorseRepresentations(String[] words) {
3        String[] morse = {
4            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
5            "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
6            "..-","...-",".--","-..-","-.--","--.."
7        };
8        
9        Set<String> set = new HashSet<>();
10        
11        for (String word : words) {
12            StringBuilder sb = new StringBuilder();
13            
14            for (char ch : word.toCharArray()) {
15                sb.append(morse[ch - 'a']);
16            }
17            
18            set.add(sb.toString());
19        }
20        
21        return set.size();
22    }
23}