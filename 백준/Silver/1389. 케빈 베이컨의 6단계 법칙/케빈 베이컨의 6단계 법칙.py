import sys
input = sys.stdin.readline
from collections import deque

def BFS(v):
    dq = deque([v])
    visit[v] = 1

    while dq:
        tmp = dq.popleft()
        for i in g[tmp]:
            if visit[i] == 0:
                visit[i] = visit[tmp]+1
                dq.append(i)

n, m = map(int, input().split())
g = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

res = []
for i in range(1, n+1):
    visit = [0] * (n+1)
    if visit[i] == 0:
        BFS(i)
        res.append(sum(visit))

print(res.index(min(res))+1)