def DFS(l, s, c):
    global res
    if c>limit:
        return
    if l == n:
        if s>res:
            res = s
    else:
        DFS(l+1, s+score[l], c+cal[l])
        DFS(l+1, s, c)

t = int(input())
for tc in range(1, t+1):
    n, limit = map(int, input().split())
    score = []
    cal = []
    res = 0
    for _ in range(n):
        a, b = map(int, input().split())
        score.append(a)
        cal.append(b)
    DFS(0,0,0)
    print('#%d' %tc, res)