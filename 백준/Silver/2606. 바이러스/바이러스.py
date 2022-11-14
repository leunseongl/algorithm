import sys
sys.setrecursionlimit(10 ** 7)
input = sys.stdin.readline

def DFS(v):
    for i in range(1, n+1):
        if visit[i] == 0 and g[v][i] == 1:
            visit[i] = 1
            DFS(i)

n = int(input())
m = int(input())
g = [[0] * (n+1) for _ in range(n+1)]
visit = [0] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    g[a][b] = 1
    g[b][a] = 1

cnt = 0
DFS(1)
for i in range(1, n+1):
    if visit[i] == 1:
        cnt+=1
print(cnt-1)