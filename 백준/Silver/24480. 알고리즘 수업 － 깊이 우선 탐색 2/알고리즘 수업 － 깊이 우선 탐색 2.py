import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def DFS(s):
    global tmp
    ch[s] = tmp
    g[s].sort(reverse=True)
    for i in g[s]:
        if ch[i] == 0:
            tmp += 1
            DFS(i)

n, m, r = map(int, input().split())
g = [[]for _ in range(n+1)]
ch = [0] * (n+1)
tmp = 1
for _ in range(m):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)

DFS(r)

for i in range(1, n+1):
    print(ch[i])