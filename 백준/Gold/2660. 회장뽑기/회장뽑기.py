n = int(input())
g = [[100]*(n+1) for _ in range(n+1)]

for i in range(1, n+1):
    g[i][i] = 0

while True:
    a, b = map(int, input().split())
    if a == -1 and b == -1:
        break
    g[a][b] = 1
    g[b][a] = 1

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            g[i][j] = min(g[i][j], g[i][k]+g[k][j])

li = [0] * (n+1)
score = 100
for i in range(1, n+1):
    for j in range(1, n+1):
        li[i] = max(li[i], g[i][j])
    score = min(score, li[i])

out = []
for i in range(1, n+1):
    if li[i] == score:
        out.append(i)

print(score, len(out))
print(*out)