import sys
sys.setrecursionlimit(10**6)

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def DFS(x, y):
    ch1[x][y] = 1
    for i in range(4):
        xx = x+dx[i]
        yy = y+dy[i]
        if 0<=xx<n and 0<=yy<n and ch1[xx][yy] == 0 and board[xx][yy] == board[x][y]:
            DFS(xx, yy)

def DFS2(x, y):
    ch2[x][y] = 1
    for i in range(4):
        xx = x+dx[i]
        yy = y+dy[i]
        if 0<=xx<n and 0<=yy<n and ch2[xx][yy] == 0 and board[xx][yy] == board[x][y]:
            DFS2(xx, yy)

n = int(input())
board = [list(input()) for _ in range(n)]
ch1 = [[0]*n for _ in range(n)]
cnt1 = 0

for i in range(n):
    for j in range(n):
        if ch1[i][j] == 0:
            DFS(i, j)
            cnt1 += 1

print(cnt1, end=' ')

ch2 = [[0]*n for _ in range(n)]
cnt2 = 0

for i in range(n):
    for j in range(n):
        if board[i][j] == 'R':
            board[i][j] = 'G'

for i in range(n):
    for j in range(n):
        if ch2[i][j] == 0:
            DFS2(i, j)
            cnt2 += 1

print(cnt2)
