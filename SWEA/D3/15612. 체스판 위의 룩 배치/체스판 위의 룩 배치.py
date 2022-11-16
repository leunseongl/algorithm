def check(arr):
    x = []
    y = []
    for i in range(8):
        for j in range(8):
            if arr[i][j] == 'O':
                x.append(i)
                y.append(j)
    if len(x) != 8 or len(set(x)) != 8 or len(set(y)) != 8:
        return False
    else:
        return True

t = int(input())
for tc in range(1, t+1):
    board = [list(input()) for _ in range(8)]
    if check(board):
        print('#%d' %tc, 'yes')
    else:
        print('#%d' %tc, 'no')
