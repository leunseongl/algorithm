def ok(x):
    for i in range(x):
        if board[x] == board[i] or abs(board[x] - board[i]) == abs(x-i):
            return False
    return True

def nqueen(x):
    global res
    if x == n:
        res += 1
        return
    else:
        for i in range(n):
            board[x] = i
            if ok(x):
                nqueen(x+1)

t = int(input())
for tc in range(1, t+1):
    n = int(input())
    board = [0] * n
    res = 0
    nqueen(0)
    print('#%d' %tc, res)