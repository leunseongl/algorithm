import sys
sys.setrecursionlimit(10**6)

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def DFS(x, y):
    global cnt
    cnt += 1
    g[x][y] = 0
    for i in range(4):
        xx = x+dx[i]
        yy = y+dy[i]
        if 0<=xx<n and 0<=yy<m and g[xx][yy] == 1:
            DFS(xx, yy)

n, m, k = map(int, input().split())
g = [[0]*m for _ in range(n)]
res = []

for _ in range(k):
    a, b = map(int, input().split())
    g[a-1][b-1] = 1

for i in range(n):
    for j in range(m):
        if g[i][j] == 1:
            cnt = 0
            DFS(i, j)
            res.append(cnt)

print(max(res))


