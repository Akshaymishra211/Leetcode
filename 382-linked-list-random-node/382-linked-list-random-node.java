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
    ListNode node;
    Random rand;
    public Solution(ListNode head) {
        this.node=head;
        this.rand=new Random();
    }
    
    public int getRandom() {
        int res=0;
        int i;
        ListNode curr=node;
        for(i=1;curr!=null;i++){
            int randNum=rand.nextInt(i);
            if(randNum==0){
                res=curr.val;
            }
            curr=curr.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */