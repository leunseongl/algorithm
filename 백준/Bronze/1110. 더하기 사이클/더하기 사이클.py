import sys
i = int(sys.stdin.readline())

count = 0
d = i

while True:
    a = d//10
    b = d%10
    c = (a+b)%10
    d = (b*10)+c
   
    count+=1
    
    if d==i:
        break

print(count)