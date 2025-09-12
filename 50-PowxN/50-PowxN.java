// Last updated: 13/09/2025, 01:52:05
class Solution {
    public double myPow(double x, int n) {
       if (n == 0) return 1;

        long exp = n; // Convert to long to handle overflow
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        return fastPow(x, exp);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1;
        double half = fastPow(x, n / 2);
        return (n % 2 == 0) ? half * half : half * half * x;
    }
}