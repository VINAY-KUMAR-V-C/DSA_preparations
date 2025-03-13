n = [1,4,3,2]
i=1
j=0
#o(n^2)
#https://www.youtube.com/watch?v=3j0SWDX4AtU
while i<len(n):
    temp = n[i]
    j = i-1
    while j>=0 and n[j]>temp:
        n[j+1] = n[j]
        j=j-1
    n[j+1] = temp
    i+=1

        
print(n)