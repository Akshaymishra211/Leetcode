/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static TreeNode ans;
    static boolean dfs(TreeNode node,TreeNode p,TreeNode q){
        if(node==null){
            return false;
        }
        else{
            boolean left=dfs(node.left,p,q);
            boolean right=dfs(node.right,p,q);
            if(ans==null && ((left && right) || (left && (node==p || node==q)) || (right && (node==p || node==q)))){
                ans=node;
            }
            return left || right || node==p || node==q;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans=null;
        dfs(root,p,q);
        return ans;
    }
}