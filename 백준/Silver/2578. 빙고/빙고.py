import sys
input = sys.stdin.readline

board = [list(map(int, input().split())) for _ in range(5)]
call = list(map(int, input().split()))
for _ in range(4):
    call += list(map(int, input().split()))
ch = [0] * 12
bingo = 0
flag = False

for n in range(25):
    if flag == True:
        break
    for i in range(5):
        if flag == True:
            break
        for j in range(5):
            if flag == True:
                break
            if call[n] == board[i][j]:
                board[i][j] = 0
                ch[i] += 1
                ch[j+5] += 1
                if i == j:
                    ch[10] += 1
                if i+j == 4:
                    ch[11] += 1
                for k in range(12):
                    if ch[k] == 5:
                        ch[k] = 0
                        bingo += 1
                        if bingo == 3:
                            flag = True
                            break
print(n)