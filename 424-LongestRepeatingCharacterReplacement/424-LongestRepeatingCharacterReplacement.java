// Last updated: 13/09/2025, 01:49:36
class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,maxlen=0,maxfreq=0,len=0;
        int[] freq=new int[26];
        while(j<s.length()){
            freq[s.charAt(j)-'A']++;
            maxfreq=Math.max(maxfreq,freq[s.charAt(j)-'A']);
            if((j-i+1)-maxfreq>k){
                freq[s.charAt(i)-'A']--;
                i++;
            }
            if ((j - i + 1) - maxfreq <= k) {
            maxlen=Math.max(maxlen,j-i+1);
            }
            j++;
        }

        return maxlen;
    }
}