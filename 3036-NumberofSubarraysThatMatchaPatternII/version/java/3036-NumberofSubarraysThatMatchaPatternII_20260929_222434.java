// Last updated: 29/09/2026, 22:24:34
1class Solution {
2    public int[] calc_LPS(int[] pat){
3        int m=pat.length;
4        int[] lps=new int[m];
5        int len=0;
6        int i=1;
7        while(i<m){
8            if(pat[i]==pat[len]){
9                len++;
10                lps[i]=len;
11                i++;
12            }else{
13                if(len!=0){
14                    len=lps[len-1];
15                }else{
16                    lps[i]=0;
17                    i++;
18                }
19            }
20        }
21        return lps;
22    }
23    public int kmp(int[] arr,int[] pattern,int[] lps){
24        int count=0;
25        int i=0;
26        int j=0;
27        while(i<arr.length){
28            if(arr[i]==pattern[j]){
29                i++;
30                j++;
31            }
32            if(j==pattern.length){
33                count++;
34                j=lps[j-1];
35            }else if(i<arr.length && arr[i]!=pattern[j]){
36                if (j != 0) {
37                    j = lps[j - 1]; // Shift pattern using LPS
38                } else {
39                    i++; // Pattern pointer is at 0, move text pointer
40                }
41            }
42        }
43        return count;
44    }
45    public int countMatchingSubarrays(int[] nums, int[] pattern) {
46        int n=nums.length;
47        int m=pattern.length;
48
49        int[] arr=new int[n-1];
50
51        for(int i=0;i<n-1;i++){
52            int num1=nums[i];
53            int num2=nums[i+1];
54
55            if(num1>num2){
56                arr[i]=-1;
57            }else if(num1==num2){
58                arr[i]=0;
59            }else{
60                arr[i]=1;
61            }
62        }
63
64        int[] lps=calc_LPS(pattern);
65
66        int count=kmp(arr,pattern,lps);
67
68        return count;
69        
70    }
71}