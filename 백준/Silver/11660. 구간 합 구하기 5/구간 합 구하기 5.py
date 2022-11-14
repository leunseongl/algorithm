import sys
input = sys.stdin.readline

n, m = map(int, input().split())
li = [list(map(int, input().split())) for _ in range(n)]
dy = [[0] * n for _ in range(n)]

for i in range(n):
    for j in range(n):
        if i == 0 and j == 0:
            dy[i][j] = li[i][j]
        elif i == 0:
            dy[0][j] = dy[0][j-1]+li[0][j]
        elif j == 0:
            dy[i][0] = dy[i-1][0]+li[i][0]
        else:
            dy[i][j] = dy[i-1][j] + sum(li[i][:j]) + li[i][j]

for _ in range(m):
    a,b,c,d = map(int, input().split())
    if a == 1 and b == 1:
        print(dy[c-1][d-1])
    elif a == 1:
        print(dy[c-1][d-1]-dy[c-1][b-2])
    elif b == 1:
        print(dy[c-1][d-1]-dy[a-2][d-1])
    else:
        print(dy[c-1][d-1]-dy[a-2][d-1]-dy[c-1][b-2]+dy[a-2][b-2])