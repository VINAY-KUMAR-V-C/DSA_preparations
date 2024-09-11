def subarraySum( nums, k):
    length = len(nums)
    final = 0
    for i in range(length):
        count = k
        for j in range(i,length):
            count-=nums[j]
            if(count==0):
                final+=1
    return final
print(subarraySum([1,-1,0],0))