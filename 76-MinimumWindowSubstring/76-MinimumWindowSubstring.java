// Last updated: 13/09/2025, 01:51:50
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int i=0;
        int j=0;
        int count=0;
        int len=Integer.MAX_VALUE;
        int startidx=-1;
        HashMap<Character,Integer> map=new HashMap<>();
        int k=0;
        while(k<t.length()){
            map.put(t.charAt(k),map.getOrDefault(t.charAt(k),0)+1);
            k++;
        }
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))){
                if(map.get(s.charAt(j))>0){
                    count++;
                }
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
            }
            while(count==t.length()){
                if(j-i+1<len){
                    len=j-i+1;
                    startidx=i;
                }
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                    if(map.get(s.charAt(i))>0){
                    count--;
                }
                }
                i++;
                
            }
            j++;

        }
        if (startidx == -1) {
            return "";
        } else {
            return s.substring(startidx, startidx + len);
        }
    }
}