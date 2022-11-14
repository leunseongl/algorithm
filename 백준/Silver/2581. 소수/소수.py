m = int(input())
n = int(input())
sum = 0
cnt = 0
li = []

for i in range(m,n+1):
    error = 0
    if i > 1:
        for j in range(2, i):
            if i%j == 0:
                error += 1
        if error == 0:
            li.append(i)
            sum += i
            cnt += 1
if cnt == 0:
    print(-1)
else:
    print(sum)
    print(min(li))