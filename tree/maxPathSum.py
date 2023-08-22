#left right node
class MaxPathFinder:
    maxpath = -2**31
    def maxPathFinder(self,tree):
        if tree==None:
            return 0
        else:
            left_max_value = max(0,self.maxPathFinder(tree.left))
            right_max_value = max(0,self.maxPathFinder(tree.right))
            #to get current max path and set in global varibale 
            self.maxpath = max(left_max_value+right_max_value+tree.data,self.maxpath)
            #selecting either of the max side for further checking 
            return max(left_max_value,right_max_value)+tree.data
    def getMaxPath(self,tree):
        self.maxPathFinder(tree)
        return self.maxpath
