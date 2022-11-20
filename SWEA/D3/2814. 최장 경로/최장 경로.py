def DFS(x, cnt):
    global res
    res = max(res, cnt)
    for k in g[x]:
        if visit[k] == 0:
            visit[k] = 1
            DFS(k, cnt+1)
            visit[k] = 0

t = int(input())
for tc in range(1, t+1):
    n, m = map(int, input().split())
    g = [[]*(n+1) for _ in range(n+1)]
    for _ in range(m):
        a, b = map(int, input().split())
        g[a].append(b)
        g[b].append(a)
    res = 0
    visit = [0] * (n+1)
    for i in range(1, n+1):
        if visit[i] == 0:
            visit[i] = 1
            DFS(i, 1)
            visit[i] = 0


    print('#%d' %tc, res)