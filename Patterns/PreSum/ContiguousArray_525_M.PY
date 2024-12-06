class Solution:
    def findMaxLength(self, nums):
        length = len(nums)
        map = dict()
        # map of count vs index
        map[0] = -1
        count = 0
        res = 0
        for i in range(0,length):
            count += -1 if nums[i]==0 else 1
            if count in map.keys():
                res = max(res,i-(map[count]))
            else:
                map[count] = i
        return res
print(Solution().findMaxLength([0,0,1,0,1,0,0,0]))
# 0   1   2   3   4   5   6   7
# 0   0   1   0   1   0   0   0
#-1  -2  -1  -2  -1  -2  -3  -4

# similar first -1 to last -1
