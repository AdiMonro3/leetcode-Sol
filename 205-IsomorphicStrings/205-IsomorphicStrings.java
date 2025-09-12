// Last updated: 13/09/2025, 01:50:45
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> map =new HashMap<>();
        for(int i=0;i<s.length();i++){
            char chars=s.charAt(i);
            char chart=t.charAt(i);
            if(!map.containsKey(chars)){
                if(!map.containsValue(chart)){
                    map.put(chars,chart);
                }
                else{
                    return false;
                }
            }
            else{
                char ch=map.get(chars);
                if(ch!=chart){
                    return false;
                }
            }
        }
        return true;
    }
}