class Solution {
    public static void build(int i,Node node,String str,int n){
        if(i>=n){
            node.isEnd=true;
            return;
        }
        if(node.child[str.charAt(i)-'a']==null){
            node.child[str.charAt(i)-'a']=new Node();
        }
        build(i+1,node.child[str.charAt(i)-'a'],str,n);
    }
    public static boolean search(Node node,int start,int end,String str){
        if(node==null){
            return false;
        }
        else if(start>end){
            return node.isEnd;
        }
        else{
            return search(node.child[str.charAt(start)-'a'],start+1,end,str);
        }
    }
    public static boolean func(int idx,String str,Node node,int n,int dp[]){
        if(idx>=n){
            return true;
        }
        else if(dp[idx]!=-1){
            return dp[idx]==1;
        }
        boolean ans=false;
        for(int j=idx;j<n;j++){
            if(search(node,idx,j,str)){
                ans=ans || func(j+1,str,node,n,dp);
            }
        }
        dp[idx]=ans?1:0;
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Node root=new Node();
        for(int i=0;i<wordDict.size();i++){
            build(0,root,wordDict.get(i),wordDict.get(i).length());
        }
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return func(0,s,root,n,dp);
    }
    static class Node{
        Node child[];
        boolean isEnd;
        public Node(){
            this.child=new Node[26];
        }
    }
}