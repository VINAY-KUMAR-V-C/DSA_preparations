# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return None
        oldVSNew = dict()
        def travers(node):
            if node in oldVSNew.keys():
                return oldVSNew[node]
            else :
                listi = []
                oldVSNew[node] = Node(node.val,listi)
                for i in node.neighbors:
                    listi.append(travers(i))
        return travers(node,oldVSNew)
