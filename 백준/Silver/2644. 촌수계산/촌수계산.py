import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def DFS(s, num):
    num += 1
    visit[s] = 1
    if s == b:
        res.append(num)
    for i in g[s]:
        if visit[i] == 0:
            DFS(i, num)

n = int(input())
a, b = map(int, input().split())
g = [[] for _ in range(n+1)]
visit = [0] * (n+1)
m = int(input())
res = []

for _ in range(m):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)

DFS(a,0)

if len(res) == 0:
    print(-1)
else:
    print(res[0]-1)