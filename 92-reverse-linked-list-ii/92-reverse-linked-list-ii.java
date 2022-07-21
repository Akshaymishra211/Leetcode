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
    public static ListNode reverse(ListNode node,int n){
        ListNode dummy=null,first=node;
        while(n>0){
            ListNode temp=node.next;
            node.next=dummy;
            dummy=node;
            node=temp;
            n--;
        }
        first.next=node;
        return dummy;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        head=dummy;
        int n=right-left+1;
        while(left>1){
            head=head.next;
            left--;
        }
        head.next=reverse(head.next,n);
        return dummy.next;
    }
}