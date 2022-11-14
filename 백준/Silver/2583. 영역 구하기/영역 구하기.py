import sys
sys.setrecursionlimit(10**6)
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

m, n, k = map(int, input().split())
board = [[0]*n for _ in range(m)]
res = []
dq = deque()

for _ in range(k):
    sx, sy, ex, ey = map(int, input().split())
    for i in range(sy, ey):
        for j in range(sx, ex):
            board[i][j] = 1

for i in range(m):
    for j in range(n):
        if board[i][j] == 0:
            dq.append((i,j))
            board[i][j] = 1
            cnt = 1
            while dq:
                tmp = dq.popleft()
                for w in range(4):
                    x = tmp[0]+dx[w]
                    y = tmp[1]+dy[w]
                    if 0<=x<m and 0<=y<n and board[x][y] == 0:
                        board[x][y] = 1
                        cnt +=1
                        dq.append((x,y))
            res.append(cnt)

print(len(res))
res.sort()
print(*res)