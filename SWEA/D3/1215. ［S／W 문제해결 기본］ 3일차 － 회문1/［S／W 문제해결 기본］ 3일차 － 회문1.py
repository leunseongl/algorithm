for tc in range(10):
    long = int(input())
    board = [list(input()) for _ in range(8)]
    cnt = 0
    for i in range(8-long+1):
        for j in range(8):
            tmp = board[j][i:i+long]
            if tmp == tmp[::-1]:
                cnt +=1
            for k in range(long//2):
                if board[i+k][j] != board[long+i-1-k][j]:
                    break
            else:
                cnt +=1
    print('#%d' %(tc+1), cnt)

