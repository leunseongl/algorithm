import sys
sys.setrecursionlimit(10**6)
from collections import deque
input = sys.stdin.readline

n, m, r = map(int, input().split())
g = [[] for _ in range(n+1)]
for _ in range(m):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)

for i in range(1, n+1):
    g[i].sort(reverse=True)

dq = deque()
dq.append(r)
ch = [0] * (n+1)
ch[r] = 1
tmp = 1

while dq:
    now = dq.popleft()
    for i in g[now]:
        if ch[i] == 0:
            tmp += 1
            ch[i] = tmp
            dq.append(i)

for i in range(1, n+1):
    print(ch[i])