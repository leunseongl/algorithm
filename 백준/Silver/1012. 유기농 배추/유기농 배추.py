import sys
sys.setrecursionlimit(10**6)

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def DFS(x, y):
    farm[x][y] = 0
    for i in range(4):
        xx = x+dx[i]
        yy = y+dy[i]
        if 0<=xx<n and 0<=yy<m and farm[xx][yy] == 1:
            DFS(xx,yy)

t = int(input())

for _ in range(t):
    m, n, k = map(int, input().split())
    farm = [[0]*m for _ in range(n)]
    cnt = 0
    for _ in range(k):
        a, b = map(int, input().split())
        farm[b][a] = 1
    for i in range(n):
        for j in range(m):
            if farm[i][j] == 1:
                cnt += 1
                DFS(i, j)
    print(cnt)
