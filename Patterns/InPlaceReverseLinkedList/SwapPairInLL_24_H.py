class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def swapPairs(self, head) :
        if head==None or head.next == None:
            return head
        first = head
        second = head.next
        first.next = self.swapPairs(second.next)
        second.next = first
        return second
            
# Q : 1 2 3 4 5
# A : 2 1 4 3 5
n = Solution()
m = n.swapPairs(ListNode(1,ListNode(2,ListNode(3,ListNode(4,ListNode(5,None))))))
print(m)
