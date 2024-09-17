def twoSum( numbers,target):
    length = len(numbers)
    i=0
    j=length-1
    while(i<length and j>=0):
        if((numbers[j]+numbers[i])==target):
            return sorted([i+1,j+1])
        elif (numbers[j]>target):
            j-=1
        elif ((numbers[j]+numbers[i])>target):
            j-=1
        elif ((numbers[j]+numbers[i])<target):
            i+=1
    return [1,2]

print(twoSum([-10,-8,-2,1,2,5,6],0))