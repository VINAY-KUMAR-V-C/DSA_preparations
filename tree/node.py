class Node:
    def __init__(self,data):
        self.data = data
        self.right = None
        self.left = None
# left view must be 11,20,50,80
n = Node(10)
n.left = Node(20)
n.left.right = Node(50)
n.right = Node(30)
n.right.left = Node(60)
n.right.left.right = Node(80)
n.right.right = Node(70)