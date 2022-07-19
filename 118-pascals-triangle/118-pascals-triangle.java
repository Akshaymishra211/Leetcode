class Solution {
    static class Node{
        int val;
        Node pre,next;
        public Node(int val){
            this.val=val;
        }
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(1);
        res.add(temp);
        if(numRows==1){
            return res;
        }
        List<Integer> temp2=new ArrayList<>();
        temp2.add(1);
        temp2.add(1);
        res.add(temp2);
        Node head=new Node(1);
        Node nextNode=new Node(1);
        head.next=nextNode;
        nextNode.pre=head;
        while(numRows>2){
            Node temporary=head.next;
            addNode(temporary);
            temporary=temporary.next;
            while(temporary!=null){
                addNode(temporary);
                delete(temporary.pre.pre);
                temporary=temporary.next;
            }
            List<Integer> list=new ArrayList<>();
            temporary=head;
            while(temporary!=null){
                list.add(temporary.val);
                temporary=temporary.next;
            }
            res.add(list);
            numRows--;
        }
        return res;
    }
    static void addNode(Node next){
        Node prev=next.pre;
        Node curr=new Node(prev.val+next.val);
        prev.next=curr;
        curr.pre=prev;
        curr.next=next;
        next.pre=curr;
    }
    static void delete(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
}
