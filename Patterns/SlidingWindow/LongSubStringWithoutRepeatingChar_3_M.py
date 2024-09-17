def lengthOfLongestSubstring(s):
    length = len(s)
    alphaSet = set()
    res = 0
    if(length==0):
        return 0
    else:
        start=0
        end=1
        alphaSet.add(s[start])
        prevLength = 1
        while end<length:
            alphaSet.add(s[end])
            if len(alphaSet)==prevLength:
                res = max(res,len(alphaSet))
                while s[start]!=s[end]:
                    alphaSet.remove(s[start])
                    start+=1
                    prevLength-=1
                start+=1
            else:
                prevLength+=1   
            end+=1
        return max(res,len(alphaSet))

print(lengthOfLongestSubstring("bbbb"))