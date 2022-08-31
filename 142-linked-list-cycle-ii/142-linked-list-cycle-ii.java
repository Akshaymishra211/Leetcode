/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        boolean cycle=false;
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null && !cycle){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
            }
        }
        if(!cycle){
            return null;
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}