import sys
input = sys.stdin.readline

def DFS(cnt, l):
    global res
    if cnt == n//2:
        a = b = 0
        for i in range(n):
            for j in range(n):
                if visit[i] == 1 and visit[j] == 1:
                    a += level[i][j]
                elif visit[i] == 0 and visit[j] == 0:
                    b += level[i][j]
        res = min(res, abs(a-b))
        return

    else:
        for i in range(l, n):
            if visit[i] == 0:
                visit[i] = 1
                DFS(cnt+1, i+1)
                visit[i] = 0

n = int(input())
level = [list(map(int, input().split())) for _ in range(n)]
visit = [0]*n
res = 2147000000

DFS(0,0)
print(res)