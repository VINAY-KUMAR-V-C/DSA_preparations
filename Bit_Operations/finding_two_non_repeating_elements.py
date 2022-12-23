array = [1,2,3,4,5,2,1,5,4,6]
k = array[0]
for i in array[1:]:
    k ^=i
print(k)


#property of XOR is :
# 1: n^n == 0
# 2: n^0 == n