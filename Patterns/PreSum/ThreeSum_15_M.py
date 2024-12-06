# def threeSum(nums):
#     length =len(nums)
#     nums.sort()
#     finalCount = []
#     for i in range(0,length-2):
#         if (nums[i]) >0:
#             break
#         for j in range(i+1,length-1):
#             if (nums[i]+nums[j]) >0:
#                 break
#             if -(nums[i]+nums[j]) in nums[j+1:] and [nums[i],nums[j],-(nums[i]+nums[j])] not in finalCount:
#                 finalCount.append([nums[i],nums[j],-(nums[i]+nums[j])])
#     return finalCount
def threeSum(nums):
    length = len(nums)
    previousI = None
    nums.sort()
    finalRes = []
    for i in range(0,length-2):
        if i>0 and nums[i-1]==nums[i]:
            continue
        else:
            j = i+1
            k = length-1
            while k>j:
                if j>(i+1) and nums[j-1]==nums[j]:
                    j+=1
                    continue
                if k<(length-1) and nums[k+1]==nums[k]:
                    k-=1
                    continue
                if (nums[i]+nums[j]+nums[k])>0:
                    k-=1
                elif (nums[i]+nums[j]+nums[k])<0:
                    j+=1
                else :
                    finalRes.append([nums[i],nums[j],nums[k]])
                    j+=1
                    k-=1
    return finalRes
print(threeSum([-2,0,0,2,2])) # ans : [[-2,0,2]]
print(threeSum([-1,0,1,2,-1,-4])) #ans : [[-1,-1,2],[-1,0,1]]
print(threeSum([-2,-2,-2,-1,-1,-1,0,0,0,2,2,2])) #ans : [[-2, 0, 2], [-1, -1, 2], [0, 0, 0]]


