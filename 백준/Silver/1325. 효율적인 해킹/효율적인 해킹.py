import sys
input = sys.stdin.readline
from collections import deque

def BFS(x):
    global cnt
    visit = [0] * (n + 1)
    visit[x] = 1
    dq = deque([x])

    while dq:
        tmp = dq.popleft()
        for j in com[tmp]:
            if visit[j] == 0:
                visit[j] = 1
                dq.append(j)
                cnt += 1
    return cnt

n, m = map(int, input().split())
com = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    com[b].append(a)

res = [0]
for i in range(1, n+1):
    cnt = 0
    res.append(BFS(i))

big = max(res)
for i in range(1, n+1):
    if res[i] == big:
        print(i, end=' ')

