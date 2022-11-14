import sys
input = sys.stdin.readline

def is_promising(x):
    for i in range(x):
        if board[x] == board[i] or abs(board[x] - board[i]) == abs(x-i):
            return False
    return True

def n_queens(x):
    global res
    if x == n:
        res += 1
        return
    else:
        for i in range(n):
            board[x] = i
            if is_promising(x):
                n_queens(x+1)

n = int(input())
board = [0] * n
res = 0
n_queens(0)
print(res)

