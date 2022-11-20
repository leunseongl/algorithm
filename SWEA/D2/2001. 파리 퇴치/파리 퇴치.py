t = int(input())
for tc in range(1, t+1):
    n, m = map(int, input().split())
    area = [list(map(int, input().split())) for _ in range(n)]
    res = 0
    for i in range(n-m+1):
        for j in range(n-m+1):
            tot = 0
            for k in range(m):
                for x in range(m):
                    tot += area[i+k][j+x]
            res = max(res, tot)
    print('#%d' %tc, res)