def DFS(start):
    if len(s) == m:
        print(*s)
    else:
        for i in range(start, n+1):
            s.append(i)
            DFS(i+1)
            s.pop()

n, m = map(int, input().split())
s = []
DFS(1)