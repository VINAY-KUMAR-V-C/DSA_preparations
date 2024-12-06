def subarraySum( nums, k):
    length = len(nums)
    mapPreSumVsOccurence = dict()
    i=0
    preSum = 0
    finalCount = 0
    mapPreSumVsOccurence[preSum] = 1
    while i<length:
        preSum+=nums[i]
        if (preSum-k) in mapPreSumVsOccurence.keys():
            finalCount+=mapPreSumVsOccurence[preSum-k]
        if preSum in mapPreSumVsOccurence.keys():
            mapPreSumVsOccurence[preSum]+=1
        else:
            mapPreSumVsOccurence[preSum]=1
        i+=1
    return finalCount
print(subarraySum([1,2,3,-3,1,1,1,4,2,-3],3)) #ans : 8