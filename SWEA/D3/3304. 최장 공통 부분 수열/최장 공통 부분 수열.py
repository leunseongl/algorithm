t = int(input())
for tc in range(1, t+1):
    a, b = input().split()
    n, m = len(a), len(b)
    g = [[0 for _ in range(n+1)] for _ in range(m+1)]
    for i in range(1, m+1):
        for j in range(1, n+1):
            if b[i-1] == a[j-1]:
                g[i][j] = g[i-1][j-1]+1
            else:
                g[i][j] = max(g[i-1][j], g[i][j-1])
    print('#%d' %tc, g[-1][-1])