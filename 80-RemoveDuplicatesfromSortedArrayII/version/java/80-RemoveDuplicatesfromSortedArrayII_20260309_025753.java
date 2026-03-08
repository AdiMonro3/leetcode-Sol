// Last updated: 09/03/2026, 02:57:53
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        int currnum=nums[0];
4        int freq=0;
5        int count=0;
6        for(int i=0;i<nums.length;i++){
7            if(nums[i]==currnum){
8                freq++;
9                count++;
10                if(freq>2){ 
11                    nums[i]=Integer.MIN_VALUE;
12                    count--;
13                }
14            }
15            else{
16                currnum=nums[i];
17                freq=1;
18                count++;
19            }
20
21        }
22
23        int i=0;
24        int j=0;
25        while(j<nums.length){
26            if(i==j && nums[i]!=Integer.MIN_VALUE){
27                i++;
28                
29            }
30            else if(nums[i]==Integer.MIN_VALUE && nums[j]!=Integer.MIN_VALUE){
31                int temp = nums[i];
32                nums[i] = nums[j];
33                nums[j] = temp;
34                i++;
35            }
36            j++;
37        }
38        return count;
39    }
40}