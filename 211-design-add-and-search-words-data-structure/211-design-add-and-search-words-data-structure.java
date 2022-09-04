class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        this.root=new TrieNode();
    }
    
    public void addWord(String word) {
        add(this.root,0,word,word.length());
    }
    
    public boolean search(String word) {
        return find(this.root,0,word,word.length());
    }
    
    static void add(TrieNode node,int index,String str,int n){
        if(index>=n){
            node.isEnd=true;
        }
        else{
            if(node.child[str.charAt(index)-'a']==null){
                node.child[str.charAt(index)-'a']=new TrieNode();
            }
            add(node.child[str.charAt(index)-'a'],index+1,str,n);
        }
    }
    
    static boolean find(TrieNode node,int index,String str,int n){
        if(node==null || index>=n){
            if(node==null){
                return false;
            }
            return node.isEnd;
        }
        else{
            boolean ans=false;
            if(str.charAt(index)=='.'){
                for(int i=0;i<26 && !ans;i++){
                    ans=ans || find(node.child[i],index+1,str,n);
                }
            }
            else{
                ans=ans || find(node.child[str.charAt(index)-'a'],index+1,str,n);
            }
            return ans;
        }
    }
    
    static class TrieNode{
        TrieNode[] child;
        boolean isEnd;
        public TrieNode(){
            this.child=new TrieNode[26];
            this.isEnd=false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */