class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> lst=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            lst.add(0);
        }
        Node root=new Node(nums[n-1]);
        for(int i=n-2;i>-1;i--){
            root=insert(root,nums[i]);
            int cnt=find(root,nums[i]);
            lst.set(i,cnt);
        }
        return lst;
    }

    static class Node{
        int val,left_cnt,height,self_cnt,right_cnt;
        Node left,right;
        public Node(int val){
            this.val=val;
            this.height=1;
            this.left_cnt=0;
            this.right_cnt=0;
            this.self_cnt=1;
        }
    }
    
    static int getHeight(Node node){
        if(node==null){
            return 0;
        }
        return node.height;
    }
    
    static int getBalanceFactor(Node node){
        if(node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }
    
    static Node insert(Node node,int val){
        if(node==null){
            return new Node(val);
        }
        else if(node.val==val){
            node.self_cnt++;
        }
        else if(node.val<val){
            node.right_cnt++;
            node.right=insert(node.right,val);
        }
        else{
            node.left_cnt++;
            node.left=insert(node.left,val);
        }
        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
        int bf=getBalanceFactor(node);
        if(bf>1){
            if(getBalanceFactor(node.left)<0){
                node.left=leftRotate(node.left);
            }
            return rightRotate(node);
        }
        if(bf<-1){
            if(getBalanceFactor(node.right)>0){
                node.right=rightRotate(node.right);
            }
            return leftRotate(node);
        }
        return node;
    }
    
    static Node leftRotate(Node x){
        Node y=x.right;
        x.right_cnt=y.left_cnt;
        x.right=y.left;
        y.left=x;
        x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;
        y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
        y.left_cnt+=x.left_cnt+x.self_cnt;
        return y;
    }
    
    static Node rightRotate(Node x){
        Node y=x.left;
        x.left_cnt=y.right_cnt;
        x.left=y.right;
        y.right=x;
        x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;
        y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
        y.right_cnt+=x.right_cnt+x.self_cnt;
        return y;
    }
    
    static int find(Node node,int val){
        if(node.val==val){
            return node.left_cnt;
        }
        else if(node.val<val){
            return node.left_cnt+node.self_cnt+find(node.right,val);
        }
        else{
            return find(node.left,val);
        }
    }
}