import sys
input = sys.stdin.readline
import heapq

def dijkstra(s):
    q = []
    heapq.heappush(q, (0, s))
    dis[s] = 0
    while q:
        tmp, node = heapq.heappop(q)
        if dis[node]<tmp:
            continue
        for i in g[node]:
            cos = i[0] + dis[node]
            if cos < dis[i[1]]:
                dis[i[1]] = cos
                heapq.heappush(q, (cos, i[1]))

INF = int(1e9)
t = int(input())
for _ in range(t):
    n, m, start = map(int, input().split())
    dis = [INF] * (n+1)
    g = [[] for _ in range(n+1)]
    for _ in range(m):
        a, b, c = map(int, input().split())
        g[b].append((c, a))
    dijkstra(start)

    cnt = 0
    res = 0
    for i in dis:
        if i != INF:
            cnt += 1
            res = max(res, i)
    print(cnt, res)