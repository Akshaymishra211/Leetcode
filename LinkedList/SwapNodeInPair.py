#Question:
#https://leetcode.com/problems/swap-nodes-in-pairs/
#Solution:
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        else:
            temp=head.next
            head.next=head.next.next
            temp.next=head
            curr=temp.next
            while curr.next and curr.next.next:
                fir=curr.next
                sec=curr.next.next
                curr.next=sec
                fir.next=sec.next
                sec.next=fir
                curr=curr.next.next
                
                
            return temp    
