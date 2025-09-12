// Last updated: 13/09/2025, 01:52:36
class Solution {
    public int romanToInt(String s) {
        // Step 1: Create a map to store Roman numerals and their values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int n = s.length();
        int total = 0;

        // Step 2: Traverse the string and apply the Roman numeral rules
        for (int i = 0; i < n; i++) {
            int value = romanMap.get(s.charAt(i));

            // Step 3: Check if we need to subtract (subtraction rule)
            if (i < n - 1 && value < romanMap.get(s.charAt(i + 1))) {
                total -= value; // Subtract if smaller than next value
            } else {
                total += value; // Otherwise, add normally
            }
        }

        return total;
    }
}
    