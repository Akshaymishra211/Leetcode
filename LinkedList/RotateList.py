#Question:
#https://leetcode.com/problems/rotate-list/
#Solution:
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        temp=head
        length=0
        while temp:
            length+=1
            temp=temp.next    
        if length==0:
            return head
        elif k%length==0:
            return head
        original=k%length
        prev=length-original
        last=head
        while prev>1:
            last=last.next
            prev-=1
        newhead=last.next
        last.next=None
        p=newhead
        while p.next:
            p=p.next
        p.next=head
        return newhead
