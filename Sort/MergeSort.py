n = [3,7,8,5,4,2,6,1]
# https://www.youtube.com/watch?v=3j0SWDX4AtU
def sort(array):
    length = len(array)
    if length<=1:
        return 
    m = length//2
    leftArray = array[:m]
    rightArray = array[m:]
    sort(leftArray)
    sort(rightArray)
    mergeSort(leftArray,rightArray,array)
def mergeSort(left,right,array):
    i = 0
    j = 0
    a = 0
    while(i<len(left) and j<len(right)):
        if left[i]<= right[j]:
            array[a] = left[i]
            i+=1
        else:
            array[a] = right[j]
            j+=1
        a+=1
    while i<len(left):
        array[a] = left[i]
        a+=1
        i+=1
    while j<len(right):
        array[a] = right[j]
        a+=1
        j+=1
sort(n)
print(n)

