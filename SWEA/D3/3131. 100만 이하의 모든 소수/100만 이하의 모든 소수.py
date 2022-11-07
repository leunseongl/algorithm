n = 1000000
li = [0] * (n+1)
for i in range(2, n+1):
    if li[i] == 0:
        print(i, end=' ')
        for j in range(i, n+1, i):
            li[j] = 1