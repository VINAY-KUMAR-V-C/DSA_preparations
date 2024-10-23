class BinarySearch:
    def findMin(self, nums: List[int]) -> int:
        #two solutions
        # i = 0
        # j = len(nums)-1
        # while j>i:
        #     m = (i+j)//2
        #     if nums[m]>nums[j]:
        #         i = m+1
        #     else:
        #         j = m
        # return nums[i]
        i,j = 0,len(nums)-1
        minimum = sys.maxsize
        while j>=i:
            m = (i+j)//2
            if nums[m]>=nums[i]:
                minimum = min(nums[i],minimum)
                i = m+1
            else:
                minimum = min(nums[m],minimum)
                j = m-1
        return minimum

#findMinfindMin([3,4,5,1,2])
