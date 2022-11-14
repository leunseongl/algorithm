def DFS(start):
    global cnt
    if len(s) == 6:
        print(*s)
    else:
        for i in range(start, n):
            s.append(a[i])
            DFS(i+1)
            s.pop()

while True:
    a = list(map(int, input().split()))
    n = a.pop(0)
    if n == 0:
        break
    a.sort()
    s = []
    DFS(0)
    print()

