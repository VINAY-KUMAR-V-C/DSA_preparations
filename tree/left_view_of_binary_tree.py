
class Node:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None

#left view
                #           10
                #   20               30
                #     50       60         70
                #                80
class LeftView:
    maxlevel = 0
    def leftView(self,node,i):
        if node==None:
            return 
        else:
            if i>self.maxlevel:
                self.maxlevel = i
                print(node.data)
            self.leftView(node.left,i+1)
            self.leftView(node.right,i+1)


# left view must be 11,20,50,80
n = Node(10)
n.left = Node(20)
n.left.right = Node(50)
n.right = Node(30)
n.right.left = Node(60)
n.right.left.right = Node(80)
n.right.right = Node(70)

obj = LeftView()
obj.leftView(n,1)

