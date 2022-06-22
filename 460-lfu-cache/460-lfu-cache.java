class LFUCache {
    public static Node head;
    public static Map<Integer,Node> mp;
    public static int size,max;
    public LFUCache(int capacity) {
        head=new Node(Integer.MAX_VALUE,Integer.MAX_VALUE);
        head.cnt=Integer.MAX_VALUE;
        head.next=head;
        head.pre=head;
        size=0;
        max=capacity;
        mp=new HashMap<>();
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)){
            return -1;
        }
        Node node=mp.get(key);
        deleteNode(node);
        node.cnt++;
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(max==0){
            return;
        }
        Node node;
        if(mp.containsKey(key)){
            node=mp.get(key);
            node.value=value;
            node.cnt++;
            deleteNode(node);
        }
        else{
            node=new Node(key,value);
            mp.put(key,node);
            if(size==max){
                mp.remove(head.pre.key);
                deleteNode(head.pre);
                size--;
            }
            size++;
        }
        update(node);
    }
    
    public static void update(Node node){
        Node temp=head;
        while(temp.next!=head){
            if(temp.next.cnt<=node.cnt){
                addNode(temp,node,temp.next);
                return;
            }
            temp=temp.next;
        }
        addNode(head.pre,node,head);
    }
    
    public static void addNode(Node preNode,Node node,Node nextNode){
        preNode.next=node;
        node.pre=preNode;
        nextNode.pre=node;
        node.next=nextNode;
    }
    
    public static void deleteNode(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    
    static class Node{
        int key,value,cnt;
        Node pre,next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
            this.cnt=1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */