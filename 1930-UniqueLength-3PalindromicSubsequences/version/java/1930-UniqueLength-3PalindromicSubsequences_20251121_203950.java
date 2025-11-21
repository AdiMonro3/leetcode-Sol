// Last updated: 21/11/2025, 20:39:50
class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first=new int[26];
        int[] last=new int[26];

        Arrays.fill(first,-1);
        Arrays.fill(last,-1);

        for(int i=0;i<s.length();i++){
            int x=s.charAt(i)-'a';

            if(first[x]==-1){
                first[x]=i;
            }
            last[x]=i;
        }
        int ans=0;
        for(int i=0;i<26;i++){

            int u=first[i];
            int v=last[i];
            if(u==v || u==-1) continue;
            HashSet<Character> set=new HashSet<>();
            for(int j=u+1;j<v;j++){
                set.add(s.charAt(j));
            }
            ans+=set.size();
        }
        return ans;
        

    }
}