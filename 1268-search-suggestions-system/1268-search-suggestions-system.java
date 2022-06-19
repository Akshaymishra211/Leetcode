class Solution {
    public static int cnt;
    public static void buildTrie(int idx,TrieNode node,int n,String str){
        if(idx==n-1){
            if(node.child[str.charAt(idx)-'a']==null){
                node.child[str.charAt(idx)-'a']=new TrieNode();
            }
            node.child[str.charAt(idx)-'a'].isEnd=true;
        }
        else{
            if(node.child[str.charAt(idx)-'a']==null){
                node.child[str.charAt(idx)-'a']=new TrieNode();
            }
            buildTrie(idx+1,node.child[str.charAt(idx)-'a'],n,str);
        }
    }
    public static void recur(TrieNode node,Stack<Character> stack,List<String> list){
        if(node.isEnd){
            Iterator iter=stack.iterator();
            String ans="";
            while(iter.hasNext()){
                ans+=iter.next();
            }
            list.add(ans);
            cnt++;
        }
        for(int i=0;i<26 && cnt<3;i++){
            if(node.child[i]!=null){
                stack.push((char)('a'+i));
                recur(node.child[i],stack,list);
                stack.pop();
            }
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root=new TrieNode();
        for(int i=0;i<products.length;i++){
            buildTrie(0,root,products[i].length(),products[i]);
        }
        Stack<Character> stack=new Stack<>();
        List<List<String>> list=new ArrayList<>();
        boolean noans=false;
        for(int i=0;i<searchWord.length();i++){
            List<String> temp=new ArrayList<>();
            if(root.child[searchWord.charAt(i)-'a']!=null && !noans){
                stack.push(searchWord.charAt(i));
                root=root.child[searchWord.charAt(i)-'a'];
                cnt=0;
                recur(root,stack,temp);
            }
            else{
                noans=true;
            }
            list.add(temp);
        }
        return list;
    }
    static class TrieNode{
        TrieNode child[];
        boolean isEnd;
        public TrieNode(){
            this.child=new TrieNode[26];
            this.isEnd=false;
        }
    }
}
