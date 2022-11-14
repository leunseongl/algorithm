def DFS():
    if len(s) == n:
        print(*s)
    else:
        for i in range(1, n+1):
            if visit[i] == 0:
                s.append(i)
                visit[i] = 1
                DFS()
                s.pop()
                visit[i] = 0

n = int(input())
visit = [0] * (n+1)
s = []
DFS()