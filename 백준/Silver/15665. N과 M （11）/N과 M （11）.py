def DFS():
    if len(s) == m:
        print(*s)
    else:
        flag = 0
        for i in range(n):
            if flag != num[i]:
                s.append(num[i])
                flag = num[i]
                DFS()
                s.pop()

n, m = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
s = []
DFS()