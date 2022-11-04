import sys
input = sys.stdin.readline

def DFS(v, tot):
    global res
    visit[v] = 1
    if sum(visit) == n and city[v][i] != 0:
        res = min(res, tot+city[v][i])
    else:
        for j in range(n):
            if visit[j] == 0 and city[v][j] != 0:
                DFS(j, tot+city[v][j])
    visit[v] = 0

n = int(input())
city = [list(map(int, input().split())) for _ in range(n)]
visit = [0] * n
res = 2147000000

for i in range(n):
    DFS(i, 0)

print(res)