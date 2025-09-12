// Last updated: 12/09/2025, 15:03:10
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static int findheight(TreeNode root, HashMap<Integer,Integer> heightmap, HashMap<Integer,Integer> levelmap,int level,int[][] max){
        if(root==null) return 0;
        int left=findheight(root.left,heightmap,levelmap,level+1,max);
        int right=findheight(root.right,heightmap,levelmap,level+1,max);
        int height=1+Math.max(left,right);
        heightmap.put(root.val,height);
        levelmap.put(root.val,level);
        if(max[0][level]==0){
            max[0][level]=height;
        }
        else if(height>max[0][level]){
            max[1][level]=max[0][level];
            max[0][level]=height;
        }
        else if(height>max[1][level]){
            max[1][level]=height;
        }
        return height;

    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        HashMap<Integer,Integer> heightmap=new HashMap<>();
        HashMap<Integer,Integer> levelmap=new HashMap<>();
        int n=100000+1;
        int[][] max=new int[2][n];
        int he=findheight(root,heightmap,levelmap,0,max);
        int m=queries.length;
        int []ans=new int[m];
        for(int i=0;i<m;i++){
            int query=queries[i];
            int Qlevel=levelmap.get(query);
            int Qheight=heightmap.get(query);
            if(Qheight==max[0][Qlevel]){
                ans[i]=Qlevel+max[1][Qlevel]-1;
            }else{
                ans[i]=Qlevel+max[0][Qlevel]-1;
            }
        }
        return ans;
    }
}