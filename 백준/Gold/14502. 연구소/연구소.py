import sys
input = sys.stdin.readline
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def make_wall(count):
    if count == 3:
        bfs()
        return
    else:
        for i in range(n):
            for j in range(m):
                if road[i][j] == 0:
                    road[i][j] = 1
                    make_wall(count+1)
                    road[i][j] = 0

def bfs():
    global res
    test = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            test[i][j] = road[i][j]
    dq = deque()
    for i in range(n):
        for j in range(m):
            if test[i][j] == 2:
                dq.append((i, j))
    while dq:
        tmp = dq.popleft()
        for k in range(4):
            x = tmp[0] + dx[k]
            y = tmp[1] + dy[k]
            if 0<=x<n and 0<=y<m and test[x][y] == 0:
                test[x][y] = 2
                dq.append((x,y))

    cnt = 0
    for i in range(n):
        for j in range(m):
            if test[i][j] == 0:
                cnt += 1
    res = max(res, cnt)

n, m = map(int, input().split())
road = [list(map(int, input().split())) for _ in range(n)]
res = 0

make_wall(0)
print(res)