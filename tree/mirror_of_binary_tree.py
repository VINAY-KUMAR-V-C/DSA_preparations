class Node:
    def __init__(self,data):
        self.data = data
        self.right = None
        self.left = None
        #           10
        #     20          20
        # 30      40  40       30

class MirrorBinaryTree:
    def checkMirror(self,tree1,tree2):
        if tree1==None and tree2==None:
            return True
        elif tree1!=None and tree2!=None and tree2.data==tree1.data:
            return self.checkMirror(tree1.left,tree2.right) and self.checkMirror(tree1.right,tree2.left)
        return False

n = Node(10)
n.left = Node(20)
n.left.left = Node(30)
n.left.right = Node(40)
n.right = Node(20)
n.right.left = Node(40)
n.right.right = Node(20)

obj = MirrorBinaryTree()
print(obj.checkMirror(n,n))