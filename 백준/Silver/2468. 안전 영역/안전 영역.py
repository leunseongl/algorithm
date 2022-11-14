import sys
sys.setrecursionlimit(10**6)

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def DFS(x, y):
    ch[x][y] = 1
    for i in range(4):
        xx = x+dx[i]
        yy = y+dy[i]
        if 0<=xx<n and 0<=yy<n and ch[xx][yy] == 0 and space[xx][yy]>water:
            DFS(xx,yy)

n = int(input())
space = [list(map(int, input().split())) for _ in range(n)]
res = 0
big = max(map(max, space))

for water in range(0, big):
    cnt = 0
    ch = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if space[i][j]>water and ch[i][j] == 0:
                DFS(i, j)
                cnt += 1
            if cnt>res:
                res = cnt
print(res)


