def DFS(x):
    if len(s) == m:
        print(*s)
    else:
        flag = 0
        for i in range(x, n):
            if li[i] != flag:
                s.append(li[i])
                flag = li[i]
                DFS(i)
                s.pop()

n, m = map(int, input().split())
li = list(map(int, input().split()))
li.sort()
s = []
DFS(0)