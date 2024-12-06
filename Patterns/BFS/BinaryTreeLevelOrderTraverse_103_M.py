# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root):
        finalRes = []
        self.traverse(root,0,finalRes)
        return finalRes
    def traverse(self,root,level,finalRes):
        if root==None:
            return
        else:
            if level==len(finalRes):
                finalRes.append([])
            self.traverse(root.left,level+1,finalRes)
            self.traverse(root.right,level+1,finalRes)
            finalRes[level].append(root.val)