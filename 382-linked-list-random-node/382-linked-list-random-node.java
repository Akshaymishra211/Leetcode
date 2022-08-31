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
    ListNode head;
    int size=1;
    public Solution(ListNode head) {
        this.head=head;
    }
    
    public int getRandom() {
        int ans=head.val;
        ListNode temp=head.next;
        for(int i=1;temp!=null;temp=temp.next,i++){
            int rand=new Random().nextInt(i+1);
            if(rand>=0 && rand<=this.size-1){
                ans=temp.val;
            }
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */