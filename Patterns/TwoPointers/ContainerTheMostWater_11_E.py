def maxArea(height):
    length = len(height)
    res = -1
    width = length-1
    i = 0
    j = length-1
    while i<j:
        left = height[i]
        right = height[j]
        if left<=right :
            i+=1
            res = max(left*width,res)
        else:
            j-=1
            res = max(right*width,res)
        width-=1
    return res
            