// Last updated: 13/09/2025, 01:52:24
class Solution {
    public static ArrayList<String> result= new ArrayList<>();
    public static void generate(int n,String s,int open,int close){
        if(s.length()==2*n){
            result.add(s);
            return;
        }
         if (open < n) {
            generate(n, s + "(", open + 1, close);
        }
        if (close < open) {
            generate(n, s + ")", open, close + 1);
        }

    }
    public List<String> generateParenthesis(int n) {
            result.clear();
            generate(n,"",0,0);

            return result;
        
    }
}