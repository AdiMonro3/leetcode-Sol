// Last updated: 23/03/2026, 15:08:51
1class Solution {
2    public int totalFruit(int[] arr) {
3        int n=arr.length;
4        HashMap<Integer,Integer> map=new HashMap<>();
5
6
7        int ans=0;
8        int i=0;
9        int j=0;
10        while(j<n){
11            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
12            j++;
13
14            if(map.size()<=2){
15                ans=Math.max(ans,j-i);
16            }else{
17                while(map.size()>2){
18                    map.put(arr[i],map.get(arr[i])-1);
19                   
20                    if(map.get(arr[i])<=0){
21                        map.remove(arr[i]);
22                    }
23                    i++;
24
25                }
26            }
27        }
28        return ans;
29    }
30}