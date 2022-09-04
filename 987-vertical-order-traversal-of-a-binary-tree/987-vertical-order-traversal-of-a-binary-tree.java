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
    public static void dfs(TreeNode node,int level,TreeMap<Integer,List<Pair>> mp,int mark){
        if(node==null){
            return;
        }
        else{
            if(!mp.containsKey(level)){
                mp.put(level,new ArrayList<>());
            }
            mp.get(level).add(new Pair(node.val,mark));
            dfs(node.left,level-1,mp,mark+1);
            dfs(node.right,level+1,mp,mark+1);
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<Pair>> mp=new TreeMap<>();
        dfs(root,0,mp,0);
        List<List<Integer>> res=new ArrayList<>();
        for(int key:mp.keySet()){
            Collections.sort(mp.get(key));
            List<Integer> temp=new ArrayList<>();
            for(Pair val:mp.get(key)){
                temp.add(val.val);
            }
            res.add(temp);
        }
        return res;
    }
    static class Pair implements Comparable<Pair>{
        int val,level;
        public Pair(int val,int level){
            this.val=val;
            this.level=level;
        }
        public int compareTo(Pair o){
            int diff=this.level-o.level;
            if(diff==0){
                return this.val-o.val;
            }
            return diff;
        }
    }
}