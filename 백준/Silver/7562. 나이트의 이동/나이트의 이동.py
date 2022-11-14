import sys
sys.setrecursionlimit(10**6)
from collections import deque

dx = [-1, -2, -2, -1, 1, 2, 2, 1]
dy = [2, 1, -1, -2, -2, -1, 1, 2]

t = int(input())
for _ in range(t):
    n = int(input())
    sx, sy = map(int, input().split())
    ex, ey = map(int, input().split())
    dis = [[0]*n for _ in range(n)]
    dq = deque()
    dq.append((sx, sy))
    while dq:
        tmp = dq.popleft()
        if tmp[0]==ex and tmp[1]==ey:
            break
        for i in range(8):
            x = tmp[0]+dx[i]
            y = tmp[1]+dy[i]
            if 0<=x<n and 0<=y<n and dis[x][y] == 0:
                dis[x][y] = dis[tmp[0]][tmp[1]]+1
                dq.append((x,y))
    print(dis[ex][ey])




