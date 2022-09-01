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
    public static int dfs(TreeNode node,int maxVal){
        if(node==null)
            return 0;
        return (maxVal<=node.val?1:0)+dfs(node.left,Math.max(maxVal,node.val))+dfs(node.right,Math.max(maxVal,node.val));
    }
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }
}