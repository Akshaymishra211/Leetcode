class WordFilter {
    public static Node root;
    public WordFilter(String[] words) {
        root=new Node();
        for(int i=0;i<words.length;i++){
            String suff="";
            int n=words[i].length();
            for(int j=n-1;j>-1;j--){
                suff+=words[i].charAt(j);
                insert(root,(suff+'{'+words[i]),0,suff.length()+n+1,i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String str="";
        for(int i=suffix.length()-1;i>-1;i--){
            str+=suffix.charAt(i);
        }
        return search(root,0,(str+'{'+prefix),str.length()+prefix.length()+1);
    }
    
    static void insert(Node node,String str,int i,int n,int idx){
        if(i>=n){
            node.index=idx;
            return;
        }
        if(node.child[str.charAt(i)-'a']==null){
            node.child[str.charAt(i)-'a']=new Node();
        }
        insert(node.child[str.charAt(i)-'a'],str,i+1,n,idx);
        node.index=idx;
    }
    
    static int search(Node node,int i,String str,int n){
        if(node==null){
            return -1;
        }
        if(i>=n){
            return node.index;
        }
        return search(node.child[str.charAt(i)-'a'],i+1,str,n);
    }
    
    static class Node{
        int index;
        Node child[];
        public Node(){
            this.child=new Node[27];
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */