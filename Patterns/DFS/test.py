numCourses = 4
prerequisites = [[1,0],[2,0],[3,1],[3,2]]
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
class Solution:
    mapPrevAndNext = {}
    def cloneGraph(self,node):
        nodeCopy = node
        if 

