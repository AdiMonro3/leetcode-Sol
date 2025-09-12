// Last updated: 13/09/2025, 01:52:32
class Solution {
    public static void generate(String digits,String[] map,List<String> result,int idx,StringBuilder sb){
        if(digits.equals("")) return;
        if(idx==digits.length()){
            result.add(sb.toString());
            return;
        }
        String curr=map[digits.charAt(idx)-'0'];

        for(char ch:curr.toCharArray()){
            sb.append(ch);
            generate(digits,map,result,idx+1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result=new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        
        String [] map={ "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        generate(digits,map,result,0,sb);
        return result;
    }
}