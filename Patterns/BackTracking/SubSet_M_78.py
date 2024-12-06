class Solution:
    def subsets(self, nums):
        finalRes = []
        self.traverse(nums,[],finalRes)
        return finalRes
    def traverse(self,nums,cur,finalRes):
        if nums==[]:
            if cur not in finalRes:
                finalRes.append(cur)
        else:
            popingEle = nums.pop(0)
            #include
            self.traverse(nums,cur,finalRes)
            curCopy = list(cur)
            curCopy.append(popingEle)
            #exclude
            self.traverse(nums,curCopy,finalRes)