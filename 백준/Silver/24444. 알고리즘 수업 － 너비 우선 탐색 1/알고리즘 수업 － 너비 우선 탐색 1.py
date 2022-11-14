import sys
sys.setrecursionlimit(10**6)
from collections import deque
input = sys.stdin.readline


n, m, r = map(int, input().split())
g = [[] for _ in range(n+1)]
visit = [0]*(n+1)
visit[r] = 1
tmp = 1

for _ in range(m):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)

for i in range(1, n+1):
    g[i].sort()

dq = deque()
dq.append(r)

while dq:
    s = dq.popleft()
    for i in g[s]:
        if visit[i] == 0:
            tmp += 1
            visit[i] = tmp
            dq.append(i)

for i in range(1, n+1):
    print(visit[i])