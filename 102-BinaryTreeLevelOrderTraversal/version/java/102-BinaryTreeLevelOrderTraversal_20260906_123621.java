// Last updated: 06/09/2026, 12:36:21
1import java.util.*;
2
3class Solution {
4    public int openLock(String[] deadends, String target) {
5        // Use a HashSet for O(1) lookups of deadends and previously visited combinations
6        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
7        
8        // Base case: if the starting point is a deadend, we are stuck immediately
9        if (visited.contains("0000")) {
10            return -1;
11        }
12        
13        // create a queue of strings
14        Queue<String> queue = new LinkedList<>();
15        
16        // add 0000 in queue
17        queue.offer("0000");
18        visited.add("0000"); // Mark start as visited so we don't return to it
19        
20        // create variable to count no. of steps
21        int steps = 0;
22        
23        // loop until queue is empty or target is achieved
24        while (!queue.isEmpty()) {
25            int size = queue.size(); // Process level by level
26            
27            for (int i = 0; i < size; i++) {
28                // pop the current element in the queue
29                String current = queue.poll();
30                
31                // check if current combination is target if yes store it in ans and break 
32                // (Here we return directly to halt execution)
33                if (current.equals(target)) {
34                    return steps;
35                }
36                
37                // loop on every index and rotate the wheel by one 
38                for (int j = 0; j < 4; j++) {
39                    // Turn wheel UP
40                    String up = rotateWheel(current, j, 1);
41                    // else add combination in a queue
42                    if (!visited.contains(up)) {
43                        visited.add(up);
44                        queue.offer(up);
45                    }
46                    
47                    // Turn wheel DOWN
48                    String down = rotateWheel(current, j, -1);
49                    // else add combination in a queue
50                    if (!visited.contains(down)) {
51                        visited.add(down);
52                        queue.offer(down);
53                    }
54                }
55            }
56            // Increment steps after processing a full level of the BFS tree
57            steps++;
58        }
59        
60        return -1; // Target is unreachable
61    }
62    
63    // Helper method to handle the string manipulation and wheel math
64    private String rotateWheel(String current, int index, int direction) {
65        char[] chars = current.toCharArray();
66        int digit = chars[index] - '0';
67        // Handle wrap-around from 9 to 0 and 0 to 9
68        digit = (digit + direction + 10) % 10;
69        chars[index] = (char) (digit + '0');
70        return new String(chars);
71    }
72}