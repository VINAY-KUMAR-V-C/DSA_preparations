def threeSumBetter(nums):
    length = len(nums)
    res = []
    for i in range(length):
        inBetweeenEle = set()
        for j in range(i+1,length):
            requiredThirdValue = -(nums[i]+nums[j])
            if requiredThirdValue in inBetweeenEle:
                threeValuesAre = sorted([nums[i],nums[j],requiredThirdValue] )
                if threeValuesAre not in res:
                    res.append(threeValuesAre)
            inBetweeenEle.add(nums[j])
    return res

def threeSumOptimal(nums):
    nums = sorted(nums)
    length = len(nums)
    i=0
    prevIValue = nums[i]-1
    res = []
    while i<length-1:
        if prevIValue==nums[i]:
            i+=1
            continue
        j = i+1
        k = length-1
        prevJValue = nums[j]-1
        prevKValue = nums[k]+1
        while j<k and j<length and k>=0:
            if prevJValue==nums[j]:
                j+=1
                continue
            if prevKValue==nums[k]:
                k-=1
                continue
            total = nums[i]+nums[j]+nums[k]
            if total<0:
                prevJValue = nums[j]
                j+=1
            elif total>0:
                prevKValue = nums[k]
                k-=1
            else:
                prevKValue = nums[k]
                prevJValue = nums[j]
                res.append([nums[i],nums[j],nums[k]])
                j+=1
                k-=1
        prevIValue = nums[i]
        i+=1
    return res

print(threeSumBetter([-1,0,1,2,-1,-4]))