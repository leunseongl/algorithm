import sys
input = sys.stdin.readline
from collections import deque

n, m = map(int, input().split())
g = [[] for _ in range(n+1)]
li = [0] * (n+1)
dq = deque()

for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    li[b] += 1

for i in range(1, n+1):
    if li[i] == 0:
        dq.append(i)

while dq:
    tmp = dq.popleft()
    print(tmp, end=' ')
    for i in g[tmp]:
        li[i] -= 1
        if li[i] == 0:
            dq.append(i)
