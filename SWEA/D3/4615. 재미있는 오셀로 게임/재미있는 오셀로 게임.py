dx = [1,1,0,-1,-1,-1,0,1]
dy = [0,1,1,1,0,-1,-1,-1]

def DFS(x, y, k, color):
    if board[x][y] == 0:
        return 0
    elif board[x][y] == color:
        return 1
    else:
        if DFS(x+dx[k], y+dy[k], k, color):
            board[x][y] = color
            return 1
        else:
            return 0

t = int(input())
for tc in range(1, t+1):
    n, m = map(int, input().split())
    board = [[0]*(n+2) for _ in range(n+2)]
    board[n//2][n//2] = 2
    board[n//2][n//2+1] = 1
    board[n//2+1][n//2] = 1
    board[n//2+1][n//2+1] = 2
    do = [list(map(int, input().split())) for _ in range(m)]

    for a, b, color in do:
        for j in range(8):
            board[a][b] = color
            DFS(a+dx[j], b+dy[j], j, color)

    black, white = 0,0
    for i in range(n):
        for j in range(n):
            if board[i + 1][j + 1] == 1:
                black += 1
            elif board[i + 1][j + 1] == 2:
                white += 1

    print('#%d' %tc, black, white)
