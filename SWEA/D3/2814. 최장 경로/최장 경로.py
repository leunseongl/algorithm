def DFS(x, cnt):
    global res
    res = max(res, cnt)

    for j in g[x]:
        if visit[j] == 0:
            visit[j] = 1
            DFS(j, cnt+1)
            visit[j] = 0

t = int(input())
for tc in range(1, t+1):
    n, m = map(int, input().split())
    g = [[] for _ in range(n+1)]
    visit = [0] * (n+1)
    res = 0

    for _ in range(m):
        a,b = map(int, input().split())
        g[a].append(b)
        g[b].append(a)

    for i in range(1, n+1):
        visit[i] = 1
        DFS(i, 1)
        visit[i] = 0

    print('#%d' %tc, res)