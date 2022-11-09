def tot(li):
    global res
    sum1 = sum2 = 0
    for i in range(100):
        for j in range(100):
            sum1 += li[i][j]
            sum2 += li[j][i]
        if sum1>res:
            res = sum1
        if sum2>res:
            res = sum2
        sum1 = sum2 = 0
    sum1 = sum2 = 0
    for i in range(100):
        sum1 += li[i][i]
        sum2 += li[100-i-1][i]
    if sum1 > res:
        res = sum1
    if sum2 > res:
        res = sum2
    return res


for _ in range(10):
    tc = int(input())
    li = [list(map(int, input().split())) for _ in range(100)]
    res = 0
    print('#%d' %tc, tot(li))