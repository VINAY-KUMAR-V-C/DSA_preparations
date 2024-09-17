def findMaxAverage( nums, k):
    res = 0
    length = len(nums)
    prevTotalValue = 0
    if k>length:
        return None
    else:
        prevTotalValue = sum(nums[:k])
        res = prevTotalValue/k
    i = k
    while i<length:
        prevTotalValue =prevTotalValue-nums[i-k]+nums[i]
        res = max(res,(prevTotalValue)/k) 

        i+=1
    return res
print(findMaxAverage([7,4,5,8,8,3,9,8,7,6],7))