import sys
sys.setrecursionlimit(10**6)
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

m, n = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(n)]
dis = [[0]*m for _ in range(n)]
dq = deque()

for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            dq.append((i,j))


while dq:
    tmp = dq.popleft()
    for i in range(4):
        x = tmp[0]+dx[i]
        y = tmp[1]+dy[i]
        if 0<=x<n and 0<=y<m and box[x][y] == 0:
            box[x][y] = 1
            dis[x][y] = dis[tmp[0]][tmp[1]]+1
            dq.append((x,y))

option = 0
for i in range(n):
    for j in range(m):
        if box[i][j] == 0:
            option = 1

res = 0
if option == 0:
    for i in range(n):
        for j in range(m):
            if dis[i][j]>res:
                res = dis[i][j]
    print(res)
else:
    print(-1)