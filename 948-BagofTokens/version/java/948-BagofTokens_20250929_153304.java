// Last updated: 29/09/2025, 15:33:04
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        Arrays.sort(people);
        int ans=0;
        int j=n-1;
        while(j>=0){
            if(people[j]==limit){
                ans++;
                j--;
            }
            else break;
        }
        int i=0;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                ans++;
                i++;
                j--;
            }
            else{
                ans++;
                j--;
            }
        }
        return ans;
    }
}