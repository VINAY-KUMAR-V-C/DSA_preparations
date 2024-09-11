nums = [1,0,0,0,0,1,1,1]
def getResult(nums):
    length = len(nums)
    count = 0
    dict = {}
    final = 0
    for i in range(0,length):
        count += +1 if nums[i]==1 else -1
        if count==0:
            final = i+1
        else:
            if count in dict.keys():
                dict[count][1] = i
            else:
                dict[count] = [i,i]
    for key in dict.keys():
        if dict[key][0]!=dict[key][1]:
            final = max(final,dict[key][1]-dict[key][0])
    return final
print(getResult(nums))

# count : +1 +0 -1 -2 -3 -2 -1 +0  
# index :  0  1  2  3  4  5  6  7 
# nums  :  1  0  0  0  0  1  1  1 

# step 1 : get max size where it becomes 0 
# step 2 : first and last index of count values 1,-1,-2,-3 in the above example 
#           and max diff of those .

#[-1 -2 -3 -2 -1],[-2 -3 -2],[+0 -1 -2 -3 -2 -1 +0] etc.. will give that in between these values there is equal number of one and zeros