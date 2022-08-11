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
    public static TreeNode prev;
    public static boolean ans;
    public static void dfs(TreeNode node){
        if(node==null){
            return;
        }
        else{
            dfs(node.left);
            if(prev!=null && prev.val>=node.val){
                ans=false;
            }
            prev=node;
            dfs(node.right);
        }
    }
    public boolean isValidBST(TreeNode root) {
        prev=null;
        ans=true;
        dfs(root);
        return ans;
    }
}