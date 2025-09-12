// Last updated: 13/09/2025, 01:49:29
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freqMap= new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
           }else {
                freqMap.put(ch, 1);
           }
        }
        List<Character>[] bucket = new List[s.length() + 1];
        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(c);
        }
        StringBuilder result = new StringBuilder();
        for (int i = s.length(); i >= 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    result.append(String.valueOf(c).repeat(i));
                }
            }
        }

        return result.toString();
        
    }
}