#Question:
#https://leetcode.com/problems/remove-nth-node-from-end-of-list/
#Solution:
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        temp=head
        count=0
        while temp:
            count+=1
            temp=temp.next
        #print(count)    
        node=(count-n)
        if node==0:
            head=head.next
            return head
        temp=head
        while node>1:
            temp=temp.next
            node-=1
        if temp.next.next:
            temp.next=temp.next.next
            return head
        else:
            temp.next=None
            return head
