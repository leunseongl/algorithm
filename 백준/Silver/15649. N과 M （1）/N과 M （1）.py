def dfs():
    if len(s) == m:
        print(*s)
        return

    for i in range(1, n+1):
        if visit[i] == 1:
            continue

        visit[i] = 1
        s.append(i)
        dfs()
        s.pop()
        visit[i] = 0


n, m = map(int, input().split())
s = []
visit = [0]*(n+1)
dfs()