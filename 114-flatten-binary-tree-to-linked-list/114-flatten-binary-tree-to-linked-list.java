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
    static TreeNode dummy;
    public static void dfs(TreeNode node){
        if(node==null){
            return;
        }
        TreeNode right=node.right;
        dummy.right=node;
        dummy=dummy.right;
        dfs(node.left);
        node.left=null;
        dfs(right);
    }
    public void flatten(TreeNode root) {
        dummy=new TreeNode();
        TreeNode res=dummy.right;
        dfs(root);
    }
}