import sys
input = sys.stdin.readline

def ch(board):
    ans = 1
    for i in range(n):
        cnt = 1
        for j in range(n-1):
            if board[j][i] == board[j+1][i]:
                cnt += 1
            else:
                cnt = 1
            ans = max(ans, cnt)

        cnt = 1
        for j in range(n-1):
            if board[i][j] == board[i][j+1]:
                cnt += 1
            else:
                cnt = 1
            ans = max(ans, cnt)
    return ans

n = int(input())
board = [list(input()) for _ in range(n)]
res = 0
for i in range(n):
    for j in range(n):
        if j+1 < n:
            if board[i][j] != board[i][j+1]:
                board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
                res = max(res, ch(board))
                board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
        if i+1 < n:
            if board[i][j] != board[i+1][j]:
                board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
                res = max(res, ch(board))
                board[i][j], board[i + 1][j] = board[i + 1][j], board[i][j]
print(res)
