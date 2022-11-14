import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

def DFS(v):
    global cnt
    visit[v] = cnt
    g[v].sort()
    for i in g[v]:
        if visit[i] == 0:
            cnt += 1
            DFS(i)

n, m, r = map(int, input().split())
g = [[] for _ in range(n+1)]
cnt = 1
visit = [0] * (n+1)

for _ in range(m):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)

DFS(r)

for i in range(1, n+1):
    print(visit[i])
