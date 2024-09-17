class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

#Start with 3 pointers 
class Solution:
    def reverseList(self, head):
        prevNode = None
        nextNode = None
        curNode = head
        while curNode!=None:
            nextNode = curNode.next
            curNode.next = prevNode
            prevNode = curNode
            curNode = nextNode
        return prevNode     

llist = ListNode(1,ListNode(2,ListNode(3,ListNode(4,ListNode(5,None)))))