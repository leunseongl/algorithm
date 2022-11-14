import sys
sys.setrecursionlimit(10**6)

def DFS(v):
    for i in range(n):
        if g[v][i] == 1 and ch[i] == 0:
            ch[i] = 1
            DFS(i)

n = int(input())
g = [list(map(int, input().split())) for _ in range(n)]
ch = [0] * n

for i in range(n):
    DFS(i)
    for j in range(n):
        if ch[j] == 1:
            print(1, end=' ')
        else:
            print(0, end=' ')
    print()
    ch = [0] * n