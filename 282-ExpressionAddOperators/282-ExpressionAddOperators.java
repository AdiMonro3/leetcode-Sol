// Last updated: 13/09/2025, 01:50:10
// class Solution {
//     public void helper(String s,String num,char prevchar,int prevnum,int idx,int sum,int target,List<String> ans){
//         if(idx>=num.length()){
//             if(sum==target){
//                 ans.add(s);
//                 return;
//             }
//             else return;
//         }
//         for(int i=idx;i<num.length();i++){
//             if(i!=idx && num.charAt(idx)=='0') return;
//             char c=num.charAt(i);
//             s+=c;
//             helper(s+'+'+c,num,'+',c-'0',i+1,sum+(c-'0'),target,ans);
//             helper(s+'-'+c,num,'-',c-'0',i+1,sum-(c-'0'),target,ans);
//             if(prevchar=='+'){
//                 int temp=sum-prevnum;
//                 int next=prevnum*(c-'0');
//                 helper(s+'*'+c,num,'*',c-'0',i+1,temp+next,target,ans);
//             }
//             else if(prevchar=='-'){
//                 int temp=sum+prevnum;
//                 int next=prevnum*(c-'0');
//                 helper(s+'*'+c,num,'*',c-'0',i+1,temp+next,target,ans);
//             }
//             else{
//                 helper(s+'*'+c,num,'*',c-'0',i+1,sum*(c-'0'),target,ans);
//             }
//         }


//     }
//     public List<String> addOperators(String num, int target) {
//         List<String> ans=new ArrayList<>();
//         helper(num.substring(0,1),num,'v',num.substring(0,1),1,num.substring(0,1),target,ans);
//         return ans;
//     }
// }
// public class Solution {
//     public void helper(String s, String num, char prevOp, long prevNum, int idx, long sum, int target, List<String> ans) {
//         if (idx == num.length()) {
//             if (sum == target) {
//                 ans.add(s);
//             }
//             return;
//         }

//         for (int i = idx; i < num.length(); i++) {
//             if (i != idx && num.charAt(idx) == '0') break; // Skip numbers with leading 0

//             String curStr = num.substring(idx, i + 1);
//             long cur = Long.parseLong(curStr);

//             if (idx == 0) {
//                 // First number
//                 helper(curStr, num, '+', cur, i + 1, cur, target, ans);
//             } else {
//                 if (prevOp == '+') {
//                     helper(s + "*" + curStr, num, '*', prevNum * cur, i + 1, sum - prevNum + (prevNum * cur), target, ans);
//                 } else if (prevOp == '-') {
//                     helper(s + "*" + curStr, num, '*', prevNum * cur, i + 1, sum + prevNum - (prevNum * cur), target, ans);
//                 } else {
//                     // Edge case for first operator being *
//                     helper(s + "*" + curStr, num, '*', prevNum * cur, i + 1, prevNum * cur, target, ans);
//                 }
//                 helper(s + "+" + curStr, num, '+', cur, i + 1, sum + cur, target, ans);
//                 helper(s + "-" + curStr, num, '-', cur, i + 1, sum - cur, target, ans);
//             }
//         }
//     }

//     public List<String> addOperators(String num, int target) {
//         List<String> ans = new ArrayList<>();
//         helper("", num, '+', 0, 0, 0, target, ans);
//         return ans;
//     }
// }
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}