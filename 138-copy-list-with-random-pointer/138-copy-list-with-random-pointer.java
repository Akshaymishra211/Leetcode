/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        while(temp!=null){
            Node node=temp.next;
            temp.next=new Node(temp.val);
            temp.next.next=node;
            temp=node;
        }
        temp=head;
        while(temp!=null){
            temp.next.random=temp.random!=null?temp.random.next:null;
            temp=temp.next.next;
        }
        Node dummy=new Node(0);
        Node res=dummy;
        temp=head;
        while(temp!=null){
            dummy.next=temp.next;
            temp.next=temp.next.next;
            temp=temp.next;
            dummy=dummy.next;
        }
        return res.next;
    }
}