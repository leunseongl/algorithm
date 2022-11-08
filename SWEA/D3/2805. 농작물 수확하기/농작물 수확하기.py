t = int(input())
for tc in range(1, t+1):
    n = int(input())
    farm = [list(map(int, input())) for _ in range(n)]
    tot = 0
    s = e = n//2

    for i in range(n):
        for j in range(s, e+1):
            tot += farm[i][j]
        if i < n//2:
            s -= 1
            e += 1
        else:
            s += 1
            e -= 1

    print('#%d' %tc, tot)