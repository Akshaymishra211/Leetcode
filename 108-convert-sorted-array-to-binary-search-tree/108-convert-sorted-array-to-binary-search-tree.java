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
    public static TreeNode func(int start,int end,int []arr){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode node=new TreeNode(arr[mid]);
        node.left=func(start,mid-1,arr);
        node.right=func(mid+1,end,arr);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        return func(0,n-1,nums);
    }
}