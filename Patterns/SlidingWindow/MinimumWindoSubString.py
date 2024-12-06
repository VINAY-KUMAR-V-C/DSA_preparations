def minWindow( s: str, t: str) -> str:
    tLen = len(t)
    tMap = dict()#initial requirement
    curMap = dict()
    for i in t:
        if i not in tMap:
            tMap[i] = 1
            curMap[i] = 0
        else:
            tMap[i] += 1
    sLen = len(s)
    i = 0
    j = 0
    count = tLen
    finalString = ""
    while j<sLen and i<sLen:
        if s[j] in t:
            if tMap[s[j]]>curMap[s[j]]:
                count-=1
            curMap[s[j]] +=1
        if count==0:
            while i<sLen:
                if s[i] not in curMap:
                    i+=1
                elif curMap[s[i]]>tMap[s[i]]:
                    curMap[s[i]]-=1
                    if finalString=="" or (j-i)<len(finalString):
                        finalString = s[i:j+1]
                    i+=1
                else :
                    if finalString=="" or (j-i)<len(finalString):
                        finalString = s[i:j+1]
                    break
        j+=1
    return finalString
print(minWindow("ADOBECODEBANC","ABC")) #ans : "BANC"
print(minWindow("a","a")) #ans : "a"
print(minWindow("a","aa")) #ans : ""
print(minWindow("bba","ab")) #ans : "ba"