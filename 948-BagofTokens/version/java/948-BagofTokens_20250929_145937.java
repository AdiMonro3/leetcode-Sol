// Last updated: 29/09/2025, 14:59:37
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n=tokens.length;
        Arrays.sort(tokens);
        int i=0,j=n-1;
        int maxpoints=0;
        int points=0;
        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i];
                points++;
                maxpoints = Math.max(maxpoints, points);
                i++;
            }
            else if (points > 0){
                power+=tokens[j];
                points--;
                j--;
            }
            else break;
        }
        return maxpoints;
    }
}