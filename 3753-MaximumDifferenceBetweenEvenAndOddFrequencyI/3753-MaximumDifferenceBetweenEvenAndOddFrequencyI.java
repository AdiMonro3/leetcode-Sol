// Last updated: 12/09/2025, 15:03:04
class Solution {
    public static int findifference(int freq[]){
        int maxodd=Integer.MIN_VALUE;
        int mineven=Integer.MAX_VALUE;
        for(int f:freq){
            if(f>0){
                if(f%2==1){
                    maxodd=Math.max(maxodd,f);
                }
                else{
                    mineven=Math.min(mineven,f);
                }
            }
        }
        return maxodd-mineven;
    }
    public int maxDifference(String s) {
        int [] freq=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        
        return findifference(freq);
    }
}