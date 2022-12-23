class Node:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None

#ancestors view
                #           10
                #   20               30
                #     50       60         70
                #                80
class Ancestor:
    findingNode = 0
    def ancestor(self,n):
        if n==None:
            return False
        if n.data==self.findingNode:
            return True
        if self.ancestor(n.left) or self.ancestor(n.right):
            print(n.data)
            return True
        return False

n = Node(10)
n.left = Node(20)
n.left.right = Node(50)
n.right = Node(30)
n.right.left = Node(60)
n.right.left.right = Node(80)
n.right.right = Node(70)
        
a = Ancestor()
a.findingNode = 80
a.ancestor(n)