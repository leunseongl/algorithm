import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def DFS(s):
    for i in g[s]:
        if visit[i] == 0:
            visit[i] = s
            DFS(i)

n = int(input())
g = [[] for _ in range(n+1)]
visit = [0]*(n+1)

for _ in range(n-1):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)

for i in range(1, n+1):
    if visit[i] == 0:
        DFS(i)

for i in range(2, n+1):
    print(visit[i])