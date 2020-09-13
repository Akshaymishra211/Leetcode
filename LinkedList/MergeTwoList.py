#Question:
#https://leetcode.com/problems/merge-two-sorted-lists/
#Solution:
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1 and not l2:
            return 
        elif not l1 and l2:
            return l2
        elif l1 and not l2:
            return l1
        if l1.val>l2.val:
            l1,l2=l2,l1
        head=l1
        while l1.next and l2:
            if l1.val==l2.val or l1.next.val>l2.val:
                t2=l2
                l2=l2.next
                t1=l1.next
                l1.next=t2
                l1=l1.next
                l1.next=t1
            else:
                l1=l1.next
        if l2:
            temp=head
            while temp.next:
                temp=temp.next
            temp.next=l2
        return head
