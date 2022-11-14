n = int(input())
i = 2
while n!=1 : #몫이 1이되면 멈춤
    if n%i==0:
        n = n//i
        print(i)
    else:
        i+=1
