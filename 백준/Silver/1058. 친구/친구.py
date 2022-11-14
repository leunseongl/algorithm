import sys
input = sys.stdin.readline

n = int(input())
con = [list(input()) for _ in range(n)]
g = [[0] * n for _ in range(n)]

for k in range(n):
    for i in range(n):
        for j in range(n):
            if con[i][j] == 'Y' or (con[i][k] == 'Y' and con[k][j] == 'Y'):
                g[i][j] = 1

for i in range(n):
    g[i][i] = 0

res = 0
for i in range(n):
    cnt = 0
    for j in range(n):
        if g[i][j] == 1:
            cnt += 1
    if cnt>res:
        res = cnt

print(res)