import sys
sys.setrecursionlimit(10 ** 7)
input = sys.stdin.readline

def DFS(v):
    visit[v] = 1
    for i in g[v]:
        if visit[i] == 0:
            visit[i] = 1
            DFS(i)

n, m = map(int, input().split())
g = [[] for _ in range(n+1)]
visit = [0] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

cnt = 0
for i in range(1, n+1):
    if visit[i] == 0:
        cnt += 1
        DFS(i)
print(cnt)