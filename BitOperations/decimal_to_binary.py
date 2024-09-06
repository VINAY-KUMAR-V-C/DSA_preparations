n = int(input("enter the number to get binary value"))
binaryString = ""
while n!=0:
    if n&1==1:
        binaryString =  "1" + binaryString
    else:
        binaryString = "0" + binaryString
    n >>= 1
print("binary value of is "+binaryString)
