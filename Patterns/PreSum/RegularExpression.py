# . any single char
# * any zero or more char
def isMatch(s,p):
    sInd = 0
    pInd = 0
    sMainInd = 0
    while(pInd<len(p)):
        if p[pInd]=='.':
            sInd+=1
            pInd+=1
        elif p[pInd]=='*':
            pass
print("*vardhan".split("*"))

