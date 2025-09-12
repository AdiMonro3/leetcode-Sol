// Last updated: 13/09/2025, 01:47:57
class Solution {
    public int subtractProductAndSum(int n) {
        int a=1;
        int c=0;
        while(n!=0){
            int b=n%10;
            a=a*b;
            c+=b;
            n=n/10;

        }
        int d=a-c;
        return d;
    }
}