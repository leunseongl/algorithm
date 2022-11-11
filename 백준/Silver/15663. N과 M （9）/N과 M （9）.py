def DFS():
    if len(s) == m:
        print(*s)
    else:
        flag = 0
        for i in range(n):
            if visit[i] == 0 and flag != num[i]:
                s.append(num[i])
                visit[i] = 1
                flag = num[i]
                DFS()
                s.pop()
                visit[i] = 0

n, m = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
s = []
visit = [0] * (n+1)
DFS()