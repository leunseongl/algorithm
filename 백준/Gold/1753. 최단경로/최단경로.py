import sys
input = sys.stdin.readline
import heapq

def dijkstra(s):
    q = []
    heapq.heappush(q, (0, s))
    dis[s] = 0
    while q:
        dist, node = heapq.heappop(q)
        if dis[node] < dist:
            continue
        for i in g[node]:
            cost = dis[node] + i[1]
            if cost < dis[i[0]]:
                dis[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


v, e = map(int, input().split())
start = int(input())
g = [[] for _ in range(v+1)]
INF = int(1e9)
dis = [INF] * (v+1)
for _ in range(e):
    a,b,c = map(int, input().split())
    g[a].append((b, c))

dijkstra(start)
for i in range(1, v+1):
    if dis[i] == INF:
        print("INF")
    else:
        print(dis[i])