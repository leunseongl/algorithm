from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

n, m = map(int, input().split())
road = [list(map(int, input())) for _ in range(n)]
dis = [[0]*m for _ in range(n)]
dis[0][0] = 1
dq = deque()
dq.append((0,0))

while dq:
    tmp = dq.popleft()
    for i in range(4):
        x = tmp[0]+dx[i]
        y = tmp[1]+dy[i]
        if 0<=x<n and 0<=y<m and road[x][y] == 1:
            road[x][y] = 0
            dis[x][y] = dis[tmp[0]][tmp[1]]+1
            dq.append((x,y))

print(dis[n-1][m-1])