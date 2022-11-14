n = int(input())
for i in range(1, n+1):
    li = list(map(int, str(i)))
    res = i+sum(li)
    if res == n:
        print(i)
        break
else:
    print(0)