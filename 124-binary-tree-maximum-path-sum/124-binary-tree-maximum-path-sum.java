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
    public static int ans;
    public static int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=dfs(node.left);
        int right=dfs(node.right);
        ans=Math.max(ans,node.val+Math.max(left,right));
        ans=Math.max(ans,node.val+left+right);
        return Math.max(0,node.val+Math.max(left,right));
    }
    public int maxPathSum(TreeNode root) {
        ans=Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
}
