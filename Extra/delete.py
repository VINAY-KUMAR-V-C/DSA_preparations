a =int(input());
binary = ""
while a!=0:
    if a&1==1:
        binary="1"+binary
    else:
        binary="0"+binary
    a>>=1
print(binary)