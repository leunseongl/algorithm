t = int(input())
for tc in range(1, t+1):
    n, k = map(int, input().split())
    puzzle = [list(map(int, input().split())) for _ in range(n)]
    res = []
    for i in range(n):
        cnt = 0
        for j in range(n):
            if puzzle[i][j] == 1:
                cnt += 1
            else:
                res.append(cnt)
                cnt = 0
        res.append(cnt)

    for i in range(n):
        cnt = 0
        for j in range(n):
            if puzzle[j][i] == 1:
                cnt += 1
            else:
                res.append(cnt)
                cnt = 0
        res.append(cnt)
    print('#%d' %tc, res.count(k))
