// Last updated: 15/10/2025, 15:42:20
class Solution {
    public static int findI(int[] arr,int target,int i,int j){
        if(target>arr[arr.length-1]) return -1;
        int res=-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(arr[mid]>target) {
                res = mid;
                j = mid - 1;
            }
            else i=mid+1;
        }
        return res;
    }
    public static long helper(int [] arr,int[] freq_arr,int i,long []dp){
        if(i>=arr.length || i==-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int target=arr[i]+2;
        long pick=(long)freq_arr[i]*arr[i]+ helper(arr,freq_arr,findI(arr,target,i+1,arr.length-1),dp);
        long notpick=helper(arr,freq_arr,i+1,dp);
        return dp[i]=Math.max(pick,notpick);
    }
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
         List<Integer> uniqueList = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int p : power) freqMap.put(p, freqMap.getOrDefault(p, 0) + 1);
        for (int p : freqMap.keySet()) uniqueList.add(p);
        Collections.sort(uniqueList);

        // convert to array
        int[] arr = new int[uniqueList.size()];
        int[] freq = new int[uniqueList.size()];
        for (int i = 0; i < uniqueList.size(); i++) {
            arr[i] = uniqueList.get(i);
            freq[i] = freqMap.get(uniqueList.get(i));
        }
        long[] dp = new long[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr,freq,0,dp);
    }
}