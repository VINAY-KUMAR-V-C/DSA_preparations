from FindMiddleValue import FindMiddleValue

class Node():
    def __init__(self, value=None):
        self.value = value
        self.next = None


node1 = Node(10)
node2 = Node(20)
node3 = Node(30)
node4 = Node(40)
node5 = Node(50)
node = node1
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5

print(FindMiddleValue().getMiddleValue(node))
