def DFS():
    if len(s) == m:
        print(*s)
    else:
        for i in range(n):
            if visit[i] == 0:
                visit[i] = 1
                s.append(num[i])
                DFS()
                visit[i] = 0
                s.pop()

n, m = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
visit = [0] * (n+1)
s = []
DFS()