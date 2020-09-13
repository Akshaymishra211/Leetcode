#OuestionLink:
#https://leetcode.com/problems/add-two-numbers/
#Solution:
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        s=l1.val+l2.val
        t=ListNode(s%10)
        carry=s//10
        head=t
        l1=l1.next
        l2=l2.next
        while l1 and l2:
            s=l1.val+l2.val
            temp=ListNode((s+carry)%10)
            t.next=temp
            t=temp
            carry=(s+carry)//10
            l1=l1.next
            l2=l2.next
        while l1:
            s=l1.val
            temp=ListNode((s+carry)%10)
            t.next=temp
            t=temp
            carry=(s+carry)//10
            l1=l1.next
        while l2:
            s=l2.val
            temp=ListNode((s+carry)%10)
            t.next=temp
            t=temp
            carry=(s+carry)//10
            l2=l2.next
        if carry!=0:
            temp=ListNode(carry)
            t.next=temp
            t=temp
        return head    
