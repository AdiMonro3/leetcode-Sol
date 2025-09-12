// Last updated: 13/09/2025, 01:48:18
class Solution {
    public int fib(int n) {
        if(n==0||n==1) return n;
        return fib(n-1)+fib(n-2);
    }
}