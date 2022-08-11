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
    public static int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        else{
            return 1+Math.max(dfs(node.left),dfs(node.right));
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        int h=dfs(root);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(h>1){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node==null){
                    return false;
                }
                q.add(node.left);
                q.add(node.right);
            }
            h--;
        }
        TreeNode node=q.poll();
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(node==null && curr!=null){
                return false;
            }
            node=curr;
        }
        return true;
    }
}
