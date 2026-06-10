// Last updated: 10/06/2026, 23:18:50
1class Solution {
2    public String[] findWords(String[] words) {
3        Set<Character> row1 = new HashSet<>(
4            Arrays.asList('q','w','e','r','t','y','u','i','o','p')
5        );
6
7        Set<Character> row2 = new HashSet<>(
8            Arrays.asList('a','s','d','f','g','h','j','k','l')
9        );
10
11        Set<Character> row3 = new HashSet<>(
12            Arrays.asList('z','x','c','v','b','n','m')
13        );
14
15        List<String> result = new ArrayList<>();
16
17        for (String word : words) {
18            String w = word.toLowerCase();
19
20            Set<Character> row;
21            if (row1.contains(w.charAt(0))) {
22                row = row1;
23            } else if (row2.contains(w.charAt(0))) {
24                row = row2;
25            } else {
26                row = row3;
27            }
28
29            boolean valid = true;
30
31            for (char ch : w.toCharArray()) {
32                if (!row.contains(ch)) {
33                    valid = false;
34                    break;
35                }
36            }
37
38            if (valid) {
39                result.add(word);
40            }
41        }
42
43        return result.toArray(new String[0]);
44    }
45}