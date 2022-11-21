dx = [1,0,-1,0]
dy = [0,-1,0,1]

def DFS(a, b, s):
    if len(s) == 6:
        if s not in res:
            res.append(s)
        return
    else:
        for k in range(4):
            x = dx[k] + a
            y = dy[k] + b
            if 0<=x<5 and 0<=y<5:
                DFS(x, y, s+board[x][y])

board = [list(input().split()) for _ in range(5)]
res = []
for i in range(5):
    for j in range(5):
        DFS(i, j, board[i][j])
print(len(res))