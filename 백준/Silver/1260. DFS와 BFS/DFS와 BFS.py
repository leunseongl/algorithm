import sys
sys.setrecursionlimit(10**6)
from collections import deque
input = sys.stdin.readline

def DFS(s):
    ch1[s] = 1
    print(s, end=' ')
    for i in g[s]:
        if ch1[i] == 0:
            DFS(i)

def BFS(s):
    dq = deque([s])
    while dq:
        tmp = dq.popleft()
        print(tmp, end=' ')
        for i in g[tmp]:
            if ch2[i] == 0:
                dq.append(i)
                ch2[i] = 1

n, m, v = map(int, input().split())
g = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

for i in range(1, n+1):
    g[i].sort()

ch1 = [0] * (n+1)
ch2 = [0] * (n+1)
ch2[v] = 1

DFS(v)
print()
BFS(v)


