t = int (input())
for tc in range(1, t+1):
    n = int(input())
    g = [list(map(int, input().split())) for _ in range(n)]
    li_90 = [[0]*n for _ in range(n)]
    li_180 = [[0]*n for _ in range(n)]
    li_270 = [[0]*n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            li_90[i][j] = g[n-j-1][i]

    for i in range(n):
        for j in range(n):
            li_180[i][j] = g[n-i-1][n-j-1]

    for i in range(n):
        for j in range(n):
            li_270[i][j] = g[j][n-i-1]

    #출력
    print('#%d' %tc)
    for i in range(n):
        for j in range(n):
            print(li_90[i][j], end='')
        print(end=' ')
        for m in range(n):
            print(li_180[i][m], end='')
        print(end=' ')
        for k in range(n):
            print(li_270[i][k], end='')
        print()