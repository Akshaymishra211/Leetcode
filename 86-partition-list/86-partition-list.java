/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerthanx=new ListNode(),greaterthanequaltox=new ListNode();
        ListNode t1=smallerthanx,t2=greaterthanequaltox;
        while(head!=null){
            if(head.val<x){
                t1.next=head;
                t1=t1.next;
            }
            else{
                t2.next=head;
                t2=t2.next;
            }
            head=head.next;
        }
        t2.next=null;
        t1.next=greaterthanequaltox.next;
        return smallerthanx.next;
    }
}