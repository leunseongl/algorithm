from collections import deque

dx = [-1, -1, -1, 1, 1, 1, 0, 0]
dy = [0, 1, -1, 0, 1, -1, 1, -1]

while True:
    dq = deque()
    cnt = 0
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    road = [list(map(int, input().split())) for _ in range(h)]
    for i in range(h):
        for j in range(w):
            if road[i][j] == 1:
                road[i][j] = 0
                dq.append((i,j))
                while dq:
                    tmp = dq.popleft()
                    for k in range(8):
                        x = tmp[0]+dx[k]
                        y = tmp[1]+dy[k]
                        if 0<=x<h and 0<=y<w and road[x][y] == 1:
                            road[x][y] = 0
                            dq.append((x, y))
                cnt += 1
    print(cnt)
