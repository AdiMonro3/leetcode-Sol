// Last updated: 13/09/2025, 01:50:58
class Solution {
    public String convertToTitle(int columnNumber) {
         StringBuilder sb = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--; // Adjust because Excel columns are 1-based
            int remainder = columnNumber % 26;
            sb.append((char) (remainder + 'A'));
            columnNumber /= 26;
        }
        
        return sb.reverse().toString();
    }
}