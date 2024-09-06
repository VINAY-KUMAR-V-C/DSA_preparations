n = int(input())
count =0
for i in range(1,n+1):
    number  = i
    while number!=0:
        if number&1==1:
            count+=1
        number>>=1
print(count)
