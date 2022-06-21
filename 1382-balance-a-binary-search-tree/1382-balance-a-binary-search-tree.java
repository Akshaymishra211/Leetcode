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
    public static void dfs(TreeNode node,List<TreeNode> list){
        if(node==null){
            return;
        }
        else{
            dfs(node.left,list);
            list.add(node);
            dfs(node.right,list);
        }
    }
    public static TreeNode dfs(int l,int r,List<TreeNode> list){
        if(l>r){
            return null;
        }
        else{
            int mid=(l+r)/2;
            list.get(mid).left=dfs(l,mid-1,list);
            list.get(mid).right=dfs(mid+1,r,list);
            return list.get(mid);
        }
    }
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        dfs(root,list);
        return dfs(0,list.size()-1,list);
    }
}