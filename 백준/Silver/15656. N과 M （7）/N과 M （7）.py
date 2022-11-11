def DFS():
    if len(li) == m:
        print(*li)
    else:
        for i in range(n):
            li.append(num[i])
            DFS()
            li.pop()

n, m = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
li = []
DFS()