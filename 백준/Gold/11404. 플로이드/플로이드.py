import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
m = int(input())
dy = [[INF] * (n+1) for _ in range(n+1)]

for i in range(1, n+1):
    dy[i][i] = 0

for _ in range(m):
    a,b,c = map(int, input().split())
    dy[a][b] = min(dy[a][b], c)

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            dy[i][j] = min(dy[i][j], dy[i][k] + dy[k][j])

for i in range(1, n+1):
    for j in range(1, n+1):
        if dy[i][j] == INF:
            print(0, end=' ')
        else:
            print(dy[i][j], end=' ')
    print()