// Last updated: 14/10/2025, 00:21:00
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
         List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // whenever you find an operator, split
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                
                // combine left and right results
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') res.add(l + r);
                        else if (c == '-') res.add(l - r);
                        else res.add(l * r);
                    }
                }
            }
        }

        // base case: if no operator found, it’s just a number
        if (res.isEmpty()) res.add(Integer.valueOf(expression));
        return res;
    }
}