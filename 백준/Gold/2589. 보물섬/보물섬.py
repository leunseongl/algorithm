import sys
sys.setrecursionlimit(10**6)
from collections import deque
input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def BFS(x, y):
    dq.append([x, y])
    ch = [[0] * b for _ in range(a)]
    ch[x][y] = 1
    cnt = 0
    while dq:
        x, y = dq.popleft()
        for k in range(4):
            xx = x + dx[k]
            yy = y + dy[k]
            if 0<=xx<a and 0<=yy<b and g[xx][yy] == 'L' and ch[xx][yy] == 0:
                ch[xx][yy] = ch[x][y]+1
                cnt = max(cnt, ch[xx][yy])
                dq.append([xx, yy])
    return cnt-1

a, b = map(int, input().split())
g = [list(input()) for _ in range(a)]
dq = deque()
res = 0

for i in range(a):
    for j in range(b):
        if i>0 and i+1<a:
            if g[i-1][j] == "L" and g[i+1][j] == 'L':
                continue
        if j>0 and j+1<b:
            if g[i][j-1] == "L" and g[i][j+1] == 'L':
                continue

        if g[i][j] == 'L':
            res = max(res, BFS(i, j))

print(res)