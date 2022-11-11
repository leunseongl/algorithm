def DFS(start):
    if len(li) == m:
        print(*li)
    else:
        for i in range(start, n):
            li.append(num[i])
            DFS(i)
            li.pop()

n, m = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
li = []
DFS(0)
