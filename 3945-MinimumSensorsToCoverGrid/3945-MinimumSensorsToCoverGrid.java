// Last updated: 12/09/2025, 15:02:58
class Solution {
    public int minSensors(int n, int m, int k) {
        int rowSen=(n+2*k)/(2*k+1);
        int colSen=(m+2*k)/(2*k+1);
        return rowSen*colSen;
    }
}