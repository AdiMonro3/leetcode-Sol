// Last updated: 22/02/2026, 09:50:57
1class Solution {
2    Map<String,Integer> memo;
3    long gcd(long a,long b){
4        while(b!=0){
5            long temp=b;
6            b=a%b;
7            a=temp;
8        }
9        return a;
10    }
11    int helper(int[] nums,long num,long dem,int i,long k){
12        if(i==nums.length){
13            if(dem!=0 && num==(long) k*dem) return 1;
14            return 0;
15        }
16        String key=i+","+num+","+dem;
17        if(memo.containsKey(key)) return memo.get(key);
18
19        long ways=0;
20
21        long newnum=num*nums[i];
22        long newdem=dem;
23        long g1=gcd(Math.abs(newnum),Math.abs(newdem));
24        ways+=helper(nums,newnum/g1,newdem/g1,i+1,k);
25        
26        newnum=num;
27        newdem=dem*nums[i];
28        long g2=gcd(Math.abs(newnum),Math.abs(newdem));
29        ways+=helper(nums,newnum/g2,newdem/g2,i+1,k);
30
31        ways+=helper(nums,num,dem,i+1,k);
32
33        memo.put(key,(int)ways);
34        return (int) ways;
35        
36    }
37    public int countSequences(int[] nums, long k) {
38        memo=new HashMap<>();
39        return helper(nums,1,1,0,k);
40    }
41}
42    