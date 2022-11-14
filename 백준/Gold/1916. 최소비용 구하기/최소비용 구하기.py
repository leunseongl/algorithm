import sys
input = sys.stdin.readline
import heapq
def dijkstra(s):
    q = []
    heapq.heappush(q, (0, s))
    dis[s] = 0
    while q:
        tmp, node = heapq.heappop(q)
        if dis[node] < tmp:
            continue
        for i in g[node]:
            cos = dis[node]+i[0]
            if cos<dis[i[1]]:
                dis[i[1]] = cos
                heapq.heappush(q, (cos, i[1]))

n = int(input())
m = int(input())
g = [[] for _ in range(n+1)]
for _ in range(m):
    a,b,c = map(int, input().split())
    g[a].append((c,b))
start, end = map(int, input().split())
INF = int(1e9)
dis = [INF] * (n+1)

dijkstra(start)
print(dis[end])