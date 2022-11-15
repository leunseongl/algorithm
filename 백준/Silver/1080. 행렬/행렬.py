def change(a, b):
    for i in range(a, a+3):
        for j in range(b, b+3):
            hy1[i][j] = 1 - hy1[i][j]

n, m = map(int, input().split())
hy1 = [list(map(int, input())) for _ in range(n)]
hy2 = [list(map(int, input())) for _ in range(n)]
cnt = 0

for i in range(n-2):
    for j in range(m-2):
        if hy1[i][j] != hy2[i][j]:
            change(i, j)
            cnt += 1
        if hy1 == hy2:
            break
    if hy1 == hy2:
        break

if hy1 == hy2:
    print(cnt)
else:
    print(-1)