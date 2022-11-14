def DFS():
    if len(s) == m:
        print(*s)
    else:
        for i in range(1, n+1):
            s.append(i)
            DFS()
            s.pop()

n, m = map(int, input().split())
s = []
DFS()