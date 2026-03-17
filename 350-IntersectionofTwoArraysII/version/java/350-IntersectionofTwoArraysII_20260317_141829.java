// Last updated: 17/03/2026, 14:18:29
1class Solution {
2    public int[] intersect(int[] nums1, int[] nums2) {
3        List<Integer> ans=new ArrayList<>();
4
5        int max1=Integer.MIN_VALUE;
6        int max2=Integer.MIN_VALUE;
7
8        for(int i=0;i<nums1.length;i++){
9            max1=Math.max(max1,nums1[i]);
10        }
11        for(int i=0;i<nums2.length;i++){
12            max2=Math.max(max2,nums2[i]);
13        }
14
15        int[] freq1=new int[max1+1];
16        int[] freq2=new int[max2+1];
17
18        for(int i=0;i<nums1.length;i++){
19            freq1[nums1[i]]++;
20        }
21        for(int i=0;i<nums2.length;i++){
22            freq2[nums2[i]]++;
23        }
24
25        for(int i=0;i<nums1.length;i++){
26            if(nums1[i]>max2) continue;
27            int temp1=freq1[nums1[i]];
28            int temp2=freq2[nums1[i]];
29
30            if(temp1==0 || temp2==0) continue;
31            else{
32                int occ=Math.min(temp1,temp2);
33                for(int j=0;j<occ;j++){
34                    ans.add(nums1[i]);
35                }
36                freq1[nums1[i]]=0;
37                freq2[nums1[i]]=0;
38            }
39        }
40        int size=ans.size();
41        int[] result=new int[size];
42        for(int i=0;i<size;i++){
43            result[i]=ans.get(i);
44        }
45        return result;
46    }
47}